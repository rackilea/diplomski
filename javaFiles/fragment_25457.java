Socket sc;
PrintStream ps;

public static void main(String a[]){
    sc = new Socket("example.com");
    PrintStream ps = new PrintStream(sc.getOutputStream());
}