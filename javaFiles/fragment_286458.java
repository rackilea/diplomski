long startTime;
   long endTime;

   btnNumZero.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            startTime = System.currentTimeMillis();
        }
    });
    btnNumZero.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseReleased(MouseEvent e) {
            endTime = System.currentTimeMillis();
            long difference = endTime - startTime;

            if (difference > 2000)
                txfNumber.setText("+");
            else
                txfNumber.setText("0");
        }
    });