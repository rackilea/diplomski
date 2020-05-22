public static void main(String[] args) {
    final JFrame view = new JFrame();

    EventQueue.invokeLater(new Runnable() {
        @Override
        public void run() {
            view.setSize(300, 300);
            view.add(new LedgerView(), BorderLayout.CENTER);
            view.setVisible(true);
        }
    }
}