// iterate by column 1 number in numerical order
for (Integer key : rowMap.keySet()) {

    // iterate by rows in this column in the order they were added
    for (Integer[] row : rowMap.get(key)) {
        String printout = key + ":";

        // iterate by columns in this row
        for (Integer col : row) {
            printout += " " + col;
        }

        System.out.println(printout);
    }
}