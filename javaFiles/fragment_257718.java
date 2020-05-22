frame.add(graphic);
    ...
    SwingUtilities.invokeLater(new Runnable() {
        @Override
        public void run() {
            graphic.grabFocus();
        }
    });