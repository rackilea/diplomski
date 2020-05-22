JSpinner spinner = new JSpinner();
    Action action = new AbstractAction() {

        @Override
        public void actionPerformed(ActionEvent e) {
            LOG.info("button " + ((Component) e.getSource()).getName());
        }
    };
    for (Component child : spinner.getComponents()) {
        if ("Spinner.nextButton".equals(child.getName())) {
            ((JButton) child).addActionListener(action);
        }
        if ("Spinner.previousButton".equals(child.getName())) {
            ((JButton) child).addActionListener(action);
        }
    }