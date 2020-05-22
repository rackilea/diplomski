RetrofitApi retrofitApi = new Retrofit
                .Builder()
                .addCallAdapterFactory(new CallAdapter.Factory() {
                    @Override
                    public CallAdapter<?, ?> get(Type returnType, Annotation[] annotations, Retrofit retrofit) {
                        CallAdapter<?, ?> nextAdapter = retrofit.nextCallAdapter(this, returnType, annotations);
                        Class<?> rawType = getRawType(returnType);
                        if (rawType == Single.class || rawType == Observable.class || rawType == Completable.class) {
                            return new RxStreamAdapter(getRawType(returnType), returnType, nextAdapter);
                        } else {
                            return nextAdapter;
                        }
                    }
                })
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()