Thread messageChecker = new Thread(new Runnable() {
    public void run() {
        while (!Thread.isInterrupted()) {
            String message = terminal.getReceivedMessage();
            // Prepare message for gui display
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    gui.methodToDisplayTheReceivedMessage(message);
                }
            }
        }
    }
}).start();