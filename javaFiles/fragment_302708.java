for (int i = 0; i < button.length; i++) {
    for (int j = 0; j < button[0].length; j++) {

        final JButton btn = button[i][j];
        final ImageIcon image = img[i][j];

        btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                btn.setIcon(btn.getIcon() == image ? cardTurned : image);

            }
        });
    }
}