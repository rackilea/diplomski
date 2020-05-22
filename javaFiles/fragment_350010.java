int row = 0;
String[][] s = new String[10][];
while(sc.hasNextLine() && i < 10) {
    String line = sc.nextLine();
    if( !line.startsWith("#")) {
        String[] s0 = sc.line.split("");
        s[row] = s0;
        row++;
    }         
}