SwingUtilities.invokeLater( 
    new Runnable() { 
        @Override public void run() {
            dialog.setVisible(true);
        }
    }
);