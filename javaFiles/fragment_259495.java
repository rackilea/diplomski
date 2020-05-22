public static void main(String[] args) throws IOException {
    String s;
    FileReader fstream=new FileReader("input.txt");
    BufferedReader in=new BufferedReader(fstream);

    while((s=in.readLine()) != null) {
        System.out.print(s);
    }
}