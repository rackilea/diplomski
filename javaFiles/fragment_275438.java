Formatter formatter = new Formatter();
    System.out.println(formatter.format("%20s %20s %20s %20s %20s", "Title*", "Title*", "Title*", "Title*", "Title*"));

    for (int i = 0; i < 10; i++) {
        formatter = new Formatter();
        String rowData = "info" + i;
        System.out.println(formatter.format("%20s %20s %20s %20s %20s", rowData, rowData, rowData, rowData, rowData));
    }