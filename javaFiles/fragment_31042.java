String [][] tableData = { {"abc", "def"}, {"ghi", "jkl"} };

    // The header
    System.out.println("+-----+-----+-----+");
    System.out.println("|     |  A  |  B  |");
    System.out.println("+-----+-----+-----+");

    int rowNumber = 1;
    // The body
    for(String[] row : tableData)
    {
        // Numbers
        System.out.print("|  " + rowNumber + "  ");

        // Elements
        for(String element : row)
        {
            System.out.print("| " + element + " ");
        }

        // New line for the end of the row
        System.out.println("|");
        rowNumber++;
    }

    // Footer
    System.out.println("+-----+-----+-----+");