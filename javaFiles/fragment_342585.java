int testKonfig = testSelectionModel.getMinSelectionIndex();

    jtable.addMouseListener(new MouseAdapter() {
        public void mousePressed(MouseEvent event) {
            if (event.getClickCount() == 2) {
                System.out.println(testKonfig);
            }
        }
    });