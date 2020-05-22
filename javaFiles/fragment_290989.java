try {
 UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
} catch(Exception e) {
 e.printStackTrace();
}

SwingUtilities.invokeLater(new Runnable() {
        @Override
        public void run() {
            jFrame.pack();
            jFrame.setVisible(true);
        }
    });