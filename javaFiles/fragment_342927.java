JTextField[] fields = new JTextField[30];
for(int i = 0; i<fields.length; i++){
    fields = new JTextField();
}

//then you can access them and modify them as normal.
fields[3].setColumns(5);
fields[3].setText("apples");