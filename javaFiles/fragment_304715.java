public void actionPerformed(ActionEvent e) {

    data= colours.getSelectedIndex();
    if(col == null)
        col = new Colour();
    col.setCol(data);//This is where the error is being flagged up              

}