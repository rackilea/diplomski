for (String[] row : rows) {
        if (row.length > 7) {
            int extraColumns = row.length - 7; //we have extra columns
            String[] fixed = new String[7]; // let's create a row in the correct format

            //copies all data before name
            for (int i = 0, j = 0; i < row.length; i++, j++) {
                fixed[j] = row[i]; //keep copying values, until we reach the name

                if (i == 3) { //hit first column with a name in it
                    for (int k = i + 1; k <= i + extraColumns; k++) { //append comma and the value that follows the name
                        fixed[i] += ", " + row[k];
                    }

                    i += extraColumns; //increase variable i and keep assigning values after it to position j
                }
            }
            row = fixed; //replaces the original broken row
        }

        //prints the resulting row, values in square brackets for clarity.
        for (String element : row) {
            System.out.print('[' + element + ']' + ",");
        }
        System.out.println();
    }