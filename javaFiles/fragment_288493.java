public final class MyApplet extends Applet implements AppletEvent {

    private static byte[] testdata;
    ...

    //This method is called in the moment of uninstallation
    public final void uninstall() {
        testData = null; //release the reference --> testData can be GC
    }
    ...

}