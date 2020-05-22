for (col = 0; col < y.length; col++) {
    for(row = 0; row < y[col].length; row++){
        int n = col + 1;
        System.out.println("Enter the name and grades of student " + n); //you are asking each time you iterate a note
        y[col][row] = scan.next();
    }System.out.println();