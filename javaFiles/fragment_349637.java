EventQueue.invokeLater(new Runnable() {
        @Override
        public void run() {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                ex.printStackTrace();
            }

            DefaultTableModel model = new DefaultTableModel(new String[]{"Company Name", "Email", "Website", "Country", "Product", "Source"}, 0);
            JTable table = new JTable(model);
            // Initialise remainder of the UI...

            ScannerWorker worker = new ScannerWorker(model);
            worker.execute();
        }
    });