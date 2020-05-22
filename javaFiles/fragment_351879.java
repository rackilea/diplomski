@Override
protected TestContainerFactory getTestContainerFactory() throws TestContainerException {
    return new TestContainerFactory() {
        @Override
        public TestContainer create(final URI baseUri, final ApplicationHandler application) throws IllegalArgumentException {
            return new TestContainer() {
                private HttpServer server;

                @Override
                public ClientConfig getClientConfig() {
                    return null;
                }

                @Override
                public URI getBaseUri() {
                    return baseUri;
                }

                @Override
                public void start() {
                    try {
                        this.server = GrizzlyWebContainerFactory.create(
                                baseUri, Collections.singletonMap("jersey.config.server.provider.packages", "<your-java-package>")
                        );
                    } catch (ProcessingException e) {
                        throw new TestContainerException(e);
                    } catch (IOException e) {
                        throw new TestContainerException(e);
                    }
                }

                @Override
                public void stop() {
                    this.server.stop();
                }
            };

        }
    };
}