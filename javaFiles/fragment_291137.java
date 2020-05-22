try {
            SwingUtilities.invokeAndWait(new Runnable() {

                @Override
                public void run() {
                    int result = JOptionPane.showOptionDialog(null, mainPanel, "Test showOptionDialog", JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                }
            });
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }