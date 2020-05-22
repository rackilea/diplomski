RequestConfig config= RequestConfig.custom()
                .setCircularRedirectsAllowed(false)
                .setConnectionRequestTimeout(4000)
                .setConnectTimeout(4000)
                .setMaxRedirects(0)
                .setRedirectsEnabled(false)
                .setSocketTimeout(4000)
                .setStaleConnectionCheckEnabled(true).build();
        request.setConfig(config);