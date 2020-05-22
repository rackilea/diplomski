JOptionPane optionPane = new JOptionPane(getPanel(),
                        JOptionPane.PLAIN_MESSAGE,
                        JOptionPane.DEFAULT_OPTION, 
                        null,
                        new Object[]{}, null);
dialog = optionPane.createDialog("import");
dialog.setVisible(true);