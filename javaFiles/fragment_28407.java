PropertyChangeListener listener = new PropertyChangeListener() {
        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            System.out.println(evt.getPropertyName() + "; " + evt.getNewValue());
            if ("state".equals(evt.getPropertyName())) {

                SwingWorker.StateValue state = (SwingWorker.StateValue) evt.getNewValue();
                switch (state) {
                    case DONE:
                        try {
                            int exitLevel = ((SwingWorker<Integer, ?>)evt.getSource()).get();
                            JOptionPane.showMessageDialog(null, "Format command completed with exit level of " + exitLevel);
                        } catch (InterruptedException | ExecutionException ex) {
                            JOptionPane.showMessageDialog(progressBar, ex.getMessage());
                        } finally {
                            progressBar.setIndeterminate(true);
                        }
                        break;
                    case STARTED:
                        progressBar.setIndeterminate(true);
                        break;
                }

            }
        }
    };
    FormatWorker worker = new FormatWorker("G");
    worker.addPropertyChangeListener(listener);
    worker.execute();