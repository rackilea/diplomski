TextView headerTextView[][] = new TextView[2][9];

for(int i = 0; i < headerTextView.length; i++){
    for(int j = 0; j < headerTextView[i].length; j++){
        headerTextView[i][j] = new TextView(this);
        headerTextView[i][j].setText("");
    }
}