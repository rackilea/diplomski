// This is just a mocked HTTP client that always returns your members.json
final OkHttpClient client = new OkHttpClient.Builder()
        .addInterceptor(staticResponse(Q43925012.class, "members.json"))
        .build();
// Gson stuff
final Gson gson = new GsonBuilder()
        // ... configure your Gson here ...
        .create();
final Retrofit retrofit = new Retrofit.Builder()
        .baseUrl("http://whatever")
        .client(client)
        .addConverterFactory(new Converter.Factory() {
            @Override
            public Converter<ResponseBody, ?> responseBodyConverter(final Type type, final Annotation[] annotations, final Retrofit retrofit) {
                // Checking if the method is declared with @ByRegExp annotation
                final ByRegExp byRegExp = findByRegExp(annotations);
                if ( byRegExp != null ) {
                    // If so, then compile the regexp pattern
                    final Pattern pattern = Pattern.compile(byRegExp.value());
                    // And resolve the list element type
                    final Type listElementType = getTypeParameter0(type);
                    // Obtaining the original your-type list type adapter
                    final TypeAdapter<?> listElementTypeAdapter = gson.getAdapter(TypeToken.get(listElementType));
                    return (Converter<ResponseBody, Object>) responseBody -> {
                        try {
                            // Getting input stream from the response body and converting it to a JsonReader -- a low level JSON parser
                            final JsonReader jsonReader = new JsonReader(new InputStreamReader(responseBody.byteStream()));
                            final List<Object> list = new ArrayList<>();
                            // Make sure that the first token is `{`
                            jsonReader.beginObject();
                            // And iterate over each JSON property
                            while ( jsonReader.hasNext() ) {
                                final String name = jsonReader.nextName();
                                final Matcher matcher = pattern.matcher(name);
                                // Check if the property need matches the pattern
                                if ( matcher.matches() ) {
                                    // And if so, just deserialize it and put it to the result list
                                    final Object element = listElementTypeAdapter.read(jsonReader);
                                    list.add(element);
                                } else {
                                    // Or skip the value entirely
                                    jsonReader.skipValue();
                                }
                            }
                            // make sure that the current JSON token is `{` - NOT optional
                            jsonReader.endObject();
                            return list;
                        } finally {
                            responseBody.close();
                        }
                    };
                }
                return super.responseBodyConverter(type, annotations, retrofit);
            }

            private ByRegExp findByRegExp(final Annotation[] annotations) {
                for ( final Annotation annotation : annotations ) {
                    if ( annotation instanceof ByRegExp ) {
                        return (ByRegExp) annotation;
                    }
                }
                return null;
            }

            // Trying to resolve how List<E> is parameterized (or raw if not)
            private Type getTypeParameter0(final Type type) {
                if ( !(type instanceof ParameterizedType) ) {
                    return Object.class;
                }
                final ParameterizedType parameterizedType = (ParameterizedType) type;
                return parameterizedType.getActualTypeArguments()[0];
            }
        })
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build();
final IService service = retrofit.create(IService.class);
final List<Member> members = service.getMembers()
        .execute()
        .body();
for ( final Member member : members ) {
    System.out.println(member.param1 + ", " + member.param2);
}