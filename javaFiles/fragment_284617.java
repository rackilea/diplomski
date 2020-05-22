public void internalFrameIconified(InternalFrameEvent e) {
        System.out.print("Maximised"); // Should be "Iconified"
    }

    public void internalFrameDeiconified(InternalFrameEvent e) {
        System.out.print("Minimised"); // Should be "Deiconified"
    }

    //...