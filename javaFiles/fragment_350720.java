// Display the 2D Array in Console...
StringBuilder sb;
for (int i = 0; i < myArray.length; i++) {
    sb = new StringBuilder();
    sb.append("Line ").append(String.valueOf((i+1))).append(" Contains ").
                append(myArray[i].length).append(" Columns Of Data.").
                append(System.lineSeparator());
    sb.append(String.join("", Collections.nCopies((sb.toString().length()-2), "="))).
                append(System.lineSeparator());

    for (int j = 0; j < myArray[i].length; j++) {
        sb.append("Column ").append(String.valueOf((j+1))).append(": -->\t").
                append(myArray[i][j]).append(System.lineSeparator());
    }
    System.out.println(sb.toString());
}