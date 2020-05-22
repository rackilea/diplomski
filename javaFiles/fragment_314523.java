// always put 16 last
    final int lastNumber = 16;
    // take it out from the list from the start
    list.remove(Integer.valueOf(lastNumber));
    for (int i = 0; i < 4; i++) {
        v = 0;
        for (int j = 0; j < 4; j++) {

            String number;
            if (i == 3 && j == 3) {
                number = Integer.toString(lastNumber);
            } else {
                number = Integer.toString(list.get(c));
                c++;
            }

            JButton btnmix = new JButton();
            btnBotonMix[i][j] = btnmix;
            btnBotonMix[i][j].setBounds(70 + 90 * (i % 10), v + 90 * (i / 10), 90, 90);
            btnBotonMix[i][j].setText(number);

            v = v + 90;
        }
    }