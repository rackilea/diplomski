try {
        Display.setDisplayMode(new DisplayMode(640, 480));
        Display.setTitle("Input Demo");
        Display.create();
        Keyboard.create();
        Keyboard.enableRepeatEvents(true);
    } catch (LWJGLException e) {
        //TODO handle exception in a proper way
    }