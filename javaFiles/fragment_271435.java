private class WindowHandler extends WindowAdapter {

    @Override
    public void windowOpened(WindowEvent e) {
        System.out.println("...");
        Timer timer = new Timer(2000, new ActionListener() {
            private int counter = 0;
            private int maxActions = 10;
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (counter) {
                    case 0:
                        // Action for case 0...
                        break;
                    case 1:
                        // Action for case 1...
                        break;
                    .
                    .
                    .
                }
                counter++;
                if (counter >= maxActions) {
                    ((Timer)e.getSource()).stop();
                }
            }
        });
        timer.start();
    }

}