bootstrap.addBundle(new SwaggerBundle<Configuration>() {
        @Override
        protected SwaggerBundleConfiguration getSwaggerBundleConfiguration(Configuration configuration) {
            if(!configuration.getSwaggerEnabled()){
                configuration.swaggerBundleConfiguration.setIsEnabled(false);
            }
            return configuration.swaggerBundleConfiguration;
        }
    });
}