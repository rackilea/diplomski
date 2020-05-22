final ExecutorService executor = Executors.newFixedThreadPool(5); // this runs stuff in background
JButton run = new JButton("Run");
// ..
run.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (Run.isEnabled()) {
                executor.execute(new Runnable() { // This is how we run stuff in background. You can use lambdas instead of Runnables.
                    public void run() {
                        final Result result = JUnitCore.runClasses(Run.class); // Run.class is different from the current JButton run.
                        SwingUtilities.invokeLater(new Runnable() { // Now we go back to the GUI thread
                            public void run() {
                                errorMessageDisplay(result);
                            }
                        });
                    }
                });
        }
    });