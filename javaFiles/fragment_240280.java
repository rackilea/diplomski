ResteasyDeployment rd = new ResteasyDeployment();
        CorsFilter filter = new CorsFilter();
        filter.setAllowedMethods("GET,POST,PUT,DELETE,OPTIONS");
        filter.getAllowedOrigins().add("*");
        rd.setProviderFactory(new ResteasyProviderFactory());
        rd.getProviderFactory().register(filter);