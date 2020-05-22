private void printArrayToScreen() {
    tv.setText(""); //Before printing your data clear the textview
    for(int i = 0; i < row; i++) {
        for(int j = 0; j < col; j++) {
            tv.append(array[i][j]+" ");
        }
        tv.append("\n");
    }
}