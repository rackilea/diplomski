try {
    GlobalScreen.registerNativeHook();
}
catch (NativeHookException ex) {
    System.err.println("There was a problem registering the native hook.");
    System.err.println(ex.getMessage());
    System.exit(1);
}

GlobalScreen.addNativeMouseListener(new NativeMouseListener());