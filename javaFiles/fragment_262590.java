public static void process_grades(String input_name, String csv_name, String pretty_name) {
    String[][] data = read_spreadsheet(input_name);

    PrintWriter out = null;
    try {
        out = new PrintWriter(csv_name);
    } catch (Exception e) {
        System.out.printf("Error: failed to open file %s.\n", input_name);
        System.exit(0);
    }
    // print header
    out.printf("name, exam score,hw score,min score\r\n");
    // go throu all the other rows
    for (int row = 1; row < data.length; row++) {
        // get Name
        String name = data[row][0] + " "+ data[row][1];
        // avg the next three cols
        double average1 = 0;
        for(int col = 2; col < 5; col++)
            average1 += Double.parseDouble(data[row][col].trim());
        average1 /= 3;
        // avg the next seven cols
        double average2 = 0;
        for(int col = 5; col < 12; col++)
            average2 += Double.parseDouble(data[row][col].trim());
        average2 /= 7;
        //get min score
        double smallestaverage = Math.min(average1,average2);
        // print the content
        out.printf("%20s: %10.2f, %8.2f, %9.2f\r\n",name, average1, average2, smallestaverage);
    }
    // flush the output and close the writer
    out.flush();
    out.close();
}