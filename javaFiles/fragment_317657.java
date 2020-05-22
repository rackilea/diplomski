JOptionPane optionPane = new JOptionPane(this,1,JOptionPane.PLAIN_MESSAGE);   
                optionPane.setOptions(new Object[]{});
                JDialog dialog = optionPane.createDialog(null, "Quick Help");

                dialog.setLocation(1000,10);
                dialog.setAlwaysOnTop(dialog.isAlwaysOnTopSupported());
                dialog.setVisible(true);