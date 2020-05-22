public final static String someString = "someString";

public boolean isMyFileOk(String filename){
    Scanner sc = new Scanner(filename);
    boolean fileOk = true;
    while(sc.hasNext() && fileOk){
        String line = sc.nextLine();
        fileOk = isMyLineOk(line);
    }
    sc.close();
    return fileOk;
}

public boolean isMyLineOk(String line){
    return line.equals(someString);
}