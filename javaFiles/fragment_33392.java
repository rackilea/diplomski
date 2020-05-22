for (int i = 0; i < button.length; i++) {
    for (int j = 0; j < button[0].length; j++) {
        final int listenerI = i;
        final int listenerJ = j;
        button[i][j].setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                press(listenerI, listenerJ);
            }
        });
    }
}