public static void main(String[] args) throws Exception {

    String datas = read("C:\\Tests\\File1.txt");
    System.out.println(datas);

    writeStringToFile(datas, "C:\\Tests\\FileOuput.txt" );


}