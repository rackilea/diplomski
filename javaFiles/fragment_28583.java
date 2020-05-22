//TOP LINES --> THIS IS THE PROBLEM
for (int i = 0; i < num; i++) {
    for (int j = 0; j < num/4; j++) {
        sb.append(line);
    }
}
System.out.println(sb);


     >>>>>>>   TO <<<<<<<<

        //Determine the column size
    String largestValue = "" + (num * num);  // for 20, this is "400"
    int strLen = largestValue.length(); // for 20, this is 3 + 1 space+  for right '|'
    int width = (num * (strLen + 2));
    width++; // for right '|'
    //TOP LINES 
    for (int i = 0; i < width; i++) {
        System.out.print('_'); // I'm outputting an underscore
    }
    System.out.println("");
    System.out.print("|");
    for (int n = 1; n <= num; n++) {
        System.out.printf(" %-" + strLen + "d|", n);
    }
    System.out.println("");
    for (int row = 1; row <= num; row++) {
        System.out.print("|");
        for (int column = 1; column <= num; column++) {
            System.out.printf(" %-" + strLen + "d|", (row * column));
        }
        System.out.println("");
    }
    //bottom LINES 
    for (int i = 0; i < width; i++) {
        System.out.print('_');
    }
    System.out.println("");