final JMenuItem item = new JMenuItem();
    item.setName("item1");

    item.addActionListener(new ActionListener() {

        public void actionPerformed(ActionEvent e) {
            String tag = item.getName();
        }
    });