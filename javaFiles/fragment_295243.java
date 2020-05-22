public CustomerServiceOfficerUI() {
    initComponents();
    this.addWindowListener(new WindowAdapter() {

        @Override
        public void windowOpened(WindowEvent e)
        {
            this.getCSODetails();
        }

        @Override
        public void windowDeiconified(WindowEvent e)
        {
            this.getCSODetails();
        }

        @Override
        public void windowActivated(WindowEvent e)
        {
            this.getCSODetails();
        }

    });
}