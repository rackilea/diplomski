class Decompressor implements HttpResponseInterceptor {

    /*
     * @see org.apache.http.HttpResponseInterceptor#process(org.apache.http.
     * HttpResponse, org.apache.http.protocol.HttpContext)
     */
    public void process(HttpResponse hreResponse, HttpContext hctContext)   throws HttpException, IOException {

        HttpEntity entity = hreResponse.getEntity();

        if (entity != null) {

            Header ceheader = entity.getContentEncoding();

            if (ceheader != null) {

                HeaderElement[] codecs = ceheader.getElements();

                for (int i = 0; i < codecs.length; i++) {

                    if (codecs[i].getName().equalsIgnoreCase("gzip")) {

                        hreResponse.setEntity(new HttpEntityWrapper(entity) {

                            @Override
                            public InputStream getContent() throws IOException, IllegalStateException {

                                return new GZIPInputStream(wrappedEntity.getContent());

                            }

                            @Override
                            public long getContentLength() {

                                return -1;

                            }

                        });

                        return;

                    }

                }

            }

        }

    }

}