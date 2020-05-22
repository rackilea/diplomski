JButton yesButton = new JButton("Ok");

    yesButton.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent arg0) {

            Window[] windows = Window.getWindows();
            for (Window window : windows) {
                if (window instanceof JDialog) {
                    JDialog dialog = (JDialog) window;
                    if (dialog.getContentPane().getComponentCount() == 1
                            && dialog.getContentPane().getComponent(0) instanceof JOptionPane) {
                        dialog.dispose();
                    }
                }
            }

        }
    });

    JOptionPane.showOptionDialog(null, "Please select prefered units",
            "BMI Calculator", JOptionPane.DEFAULT_OPTION,
            JOptionPane.QUESTION_MESSAGE, null, new Object[] {
                    metricButton, imperialButton, yesButton }, null);