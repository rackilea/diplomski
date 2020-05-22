Action action = new AbstractAction("clear text") {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("triggered the action");
        }

    };
    action.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("F1"));

    JToolBar bar = new JToolBar();
    bar.add(action);
    // set toolbar to frame and be happy