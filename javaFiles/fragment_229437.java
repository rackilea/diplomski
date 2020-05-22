Timer t = new Timer(DELAY, new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                car.translate(1, 0, frame.getWidth());
                label.repaint();

            }
        });