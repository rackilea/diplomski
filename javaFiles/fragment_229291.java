Reader r = new BufferedReader(new FileReader(infile));
StreamTokenizer strtok = new StreamTokenizer(r);
String strDest ="";
while (strtok.nextToken() != StreamTokenizer.TT_EOF) {
    strDest=strtok.sval; //strtok.toString() might be safer, but slower
    strtok.nextToken();

    System.out.println("Term = " + strtok.sval);

    //if (uniqList.contains(strDest)) {
    if (uniqMap.get(strtok.sval) != null) {
        output += str + "\r\n";
        System.out.println("Matched! Added: " + strDest +" "+ strtok.sval);
    }

    str = in.readLine();
}