public void showTable() {
    System.out.println("| Co-ordinate |  Code |");
    System.out.println("|---------------------|");
    for (String key : authTable.keySet()) {
        System.out.println("| " + key + "  |  " + authTable.get(key) + " |");
    }
    System.out.println("|---------------------|");
}

//In you mainclass
 case 2:
                //This displays the table.
                System.out.println("This is the table: ");
                authProvider.showTable();
                break;