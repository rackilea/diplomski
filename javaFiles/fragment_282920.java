for (col = 0; col < y.length; col++) {
    System.out.println("Enter the name and grades of student " + col); //you are asking each time you iterate a student
    for(row = 0; row < y[col].length; row++){
        int n = col + 1;
        y[col][row] = scan.next();
    }System.out.println();
   }