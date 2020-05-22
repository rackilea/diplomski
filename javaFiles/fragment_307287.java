private void initialize() {
    //...
    table.addMouseListener(new MouseAdapter() {
        //...
    });

    row = table.getSelectedRow();
    System.out.println("User row is: " + row);
}