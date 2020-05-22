JMenuBar bar = new JMenuBar();
    JMenu menu1 = new JMenu("Edit circle");
    JMenu help = new JMenu("Help");
    JMenu exit = new JMenu("Exit");
    bar.add(menu1);
    bar.add(help);
    bar.add(exit);
    exit.addMenuListener(new MenuListener() {

        @Override
        public void menuSelected(MenuEvent e) {
            System.out.println("Exiting");
        }

        @Override
        public void menuDeselected(MenuEvent e) {
        }

        @Override
        public void menuCanceled(MenuEvent e) {
        }
    });