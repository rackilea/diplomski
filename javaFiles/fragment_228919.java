new Thread(new Runnable() {

        public void run() {

            final RunnableOutput a = new RunnableOutput();

            if (SwingUtilities.isEventDispatchThread()) {
                SwingUtilities.invokeLater(new Runnable() {

                    @Override
                    public void run() {
                        a.setText(nameTextField0, text);
                    }
                });
            } else {
                try {
                    SwingUtilities.invokeAndWait(new Runnable() {

                        @Override
                        public void run() {
                            a.setText(nameTextField0, text);
                        }
                    });
                } catch (InterruptedException ex) {
                    Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InvocationTargetException ex) {
                    Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }).start();