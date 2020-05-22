// put this outside method, as class member
private final String[] colorsArray = {"red","yellow","green","blue"};
private int currentColor = 0;

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
    if (currentColor == colorsArray.length) {
        currentColor = 0;
    }

    jButton2.setBackground(colorsArray[currentColor]);

    currentColor = currentColor + 1;
}