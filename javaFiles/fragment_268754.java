// printing the array
    for(int row=0; row<figures.length; ++row) {
        // printing data row
        StringBuilder sb = new StringBuilder();

        group = (char)((row)+(int)'A');
        sb.append(group+" : ");
        for(int col=0; col<figures[row].length; ++col) {
            sum += figures[row][col];
            average = sum/figures[row].length;

            x = "   "+figures[row][col];
            diff = minLen - x.length();
            sb.append(String.format("%1$" + diff + "s", x));

            sb.append(" ");

        }
        System.out.printf("%-75s[%f]\n", sb.toString(), average);
    }