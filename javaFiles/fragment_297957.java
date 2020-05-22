public static void main(String[] args) throws IOException {

    FileReader fr = new FileReader("filepath");
    BufferedReader br = new BufferedReader(fr);
    String[] txt = new String[5];
    for (int i = 0; i < 5; i++) {
        txt[i] = br.readLine();
    }
    System.out.println(txt[0]); // prints null
    System.out.println(txt[1]); // works fine
    System.out.println(txt[2]); // works fine
    System.out.println(txt[3]); // works fine
    System.out.println(txt[4]); // works fine
    br.close();
}