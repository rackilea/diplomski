http
    .httpBasic()
        .withObjectPostProcessor(
            new ObjectPostProcessor<BasicAuthenticationFilter>() {
                public BasicAuthenticationFilter postProcess(BasicAuthenticationFilter filter) {
                    return new IgnoreFailuresBasicAuthenticationFilter(filter);
                }
            });