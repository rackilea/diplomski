private final CountDownLatch responseLatch = new CountDownLatch (1);

MRURLProtocol.mapDomain("gamification.fs", new MRProtocolResponseHandler() {
            @Override
            public InputStream handle(Uri uri) {
             InputStream stream = null;
                myApplication.getChamp().getImpulser().invokeRequest(method, body,new OnWebApiResponseArrived() {
                    @Override
                    public void OnSuccess(Object obj) {
                        String configString = "(function () { if (typeof(window) === 'undefined') ..... %s ....";
                        configString = String.format(configString, obj);
                        stream = new ByteArrayInputStream(configString.getBytes());

                        responseLatch.countDown();
                    }

                    @Override
                    public void OnFail(String errMsg) {
                        String configString = "(function () { if (typeof(window) === 'undefined')..... %s ....";
                        configString = String.format(configString, errMsg);
                        stream = new ByteArrayInputStream(configString.getBytes());

                        responseLatch.countDown();
                    }
                }); 

                try {
                    responseLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                return stream;
            }
        });