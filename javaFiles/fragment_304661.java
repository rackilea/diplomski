myButton.addActionListener(new ActionListener() {
        public void actionPerformed(final ActionEvent e) {
            final JButton triggerBtn = (JButton) e.getSource();
            final String originalValue = triggerBtn.getText();
            triggerBtn.setText("New");

            SwingWorker<Void, Void> sw = new SwingWorker<Void, Void>() {
                protected Void doInBackground() throws Exception {
                    Thread.sleep(10*1000);
                    return null;
                }

                @Override
                protected void done() {
                    triggerBtn.setText(originalValue);
                }

            };
            sw.execute();
        }
    });