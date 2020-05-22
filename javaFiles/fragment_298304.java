context.getRouteDefinition("systemARoute").adviceWith(context, new AdviceWithRouteBuilder() {
        @Override
        public void configure() throws Exception {
            getOriginalRoute().setRoutePolicies(null);
        }
    });