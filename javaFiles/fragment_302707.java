for (int i = 0; i < button.length; i++) {
    for (int j = 0; j < button[0].length; j++) {

        final int i2 = i;
        final int j2 = j;

        button[i][j].addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                System.out.println("Button[" + i2 + "][" + j2 + "] was pressed");
                button[i2][j2].setIcon(button[i2][j2].getIcon() == img[i2][j2] ? cardTurned : img[i2][j2]);

            }
        });
    }
}