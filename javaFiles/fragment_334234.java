stop_button.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(worker != null && !worker.isCancelled() && !worker.isDone()) {
                worker.cancel(true);
            }
        }
    });