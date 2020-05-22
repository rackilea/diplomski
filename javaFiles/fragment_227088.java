public void avvia() {
    EventQueue.invokeLater(new Runnable() {
        public void run() {
            try {
                // Hello new instance...
                FinestraPrincipale window = new FinestraPrincipale();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    });
}