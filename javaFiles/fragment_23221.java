Toolkit.getDefaultToolkit().addAWTEventListener(new AWTEventListener() {

        @Override
        public void eventDispatched(AWTEvent arg0) {
            Component c = KeyboardFocusManager.getCurrentKeyboardFocusManager().getFocusOwner();
            while(c != null) {
                if (c instanceof JOptionPane) {
                    try {
                        new Robot().keyPress(KeyEvent.VK_ENTER);
                    } catch (AWTException e) {
                        e.printStackTrace();
                        break;
                    }
                }
                c = c.getParent();
            }

        }
    }, AWTEvent.FOCUS_EVENT_MASK);