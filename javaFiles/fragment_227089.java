public void avvia() {
    EventQueue.invokeLater(new Runnable() {
        public void run() {
            try {
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    });
}