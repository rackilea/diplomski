menu1.add(new JMenuItem(new AbstractAction("With popup")
    {
        public void actionPerformed(ActionEvent event)
        {
            menu2.setEnabled(true);
            JOptionPane.showMessageDialog(Test.this, "Popup", "Popup", JOptionPane.ERROR_MESSAGE);
            menu2.add(new JMenuItem("New item"));
        }
    }));