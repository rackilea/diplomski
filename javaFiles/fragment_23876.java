ClassLoader tccl = Thread.currentThread().getContextClassLoader();
        try {
            final ClassLoader resourcesClassLoader = Resourceloader.class.getClassLoader();
        //needed for css
        Thread.currentThread().setContextClassLoader(resourcesClassLoader);
        this.primaryStage.show();
    } finally {
        Thread.currentThread().setContextClassLoader(tccl);
    }