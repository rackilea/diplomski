for (int i = 0; i < table.getRowCount(); i++) {
     Boolean isChecked = Boolean.valueOf(table.getValueAt(i, 4).toString());

     if (isChecked) {
        //get the values of the columns you need.
    } else {
        System.out.printf("Row %s is not checked \n", i);
    }
}