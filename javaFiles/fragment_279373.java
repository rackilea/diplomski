if(Display.getWidth() != container.getWidth() || Display.getHeight() != container.getHeight()) {
        try {
            app.setDisplayMode(Display.getWidth(), Display.getHeight(), false);
            app.reinit();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }