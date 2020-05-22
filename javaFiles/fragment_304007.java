Field windowListeners = WebClient.class
                .getDeclaredField("webWindowListeners_");
        windowListeners.setAccessible(true);
        Collection webWindowListeners = (Collection) windowListeners
                .get(webClient);
        webWindowListeners.clear();