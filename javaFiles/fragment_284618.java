InternalFrameListener internalFrameListener = new InternalFrameListener() {

    public void internalFrameOpened(InternalFrameEvent e) {
        System.out.print("Opened");
    }

    public void internalFrameClosing(InternalFrameEvent e) {
        System.out.print("Closing");
    }

    public void internalFrameClosed(InternalFrameEvent e) {
        System.out.print("Closed");
    }

    public void internalFrameIconified(InternalFrameEvent e) {
        System.out.print("Iconified");
    }

    public void internalFrameDeiconified(InternalFrameEvent e) {
        System.out.print("Deiconified");
    }

    public void internalFrameActivated(InternalFrameEvent e) {
        System.out.print("Activated");
    }

    public void internalFrameDeactivated(InternalFrameEvent e) {
        System.out.print("Deactivated");
    }
 };
 interFrame.addInternalFrameListener(internalFrameListener);