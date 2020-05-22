JButton clearMessageButton = new JButton(new AbstractAction("Test Result") {
    @Override
    public void actionPerformed(ActionEvent arg0) {
        SwingWorker worker = new SwingWorker() {

            @Override
            protected Object doInBackground() throws Exception {
                loaderLabel1.setVisible(true);
                TestMethod();
                return true;
            }

            public void TestMethod() {
                System.out.println(" =========START  TestMethod =========");
                try {
                    Thread.currentThread().sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(" =========complete  TestMethod =========");
            }

            protected void done() {
                loaderLabel1.setVisible(false);
            };
        };
        worker.execute();
    }
});