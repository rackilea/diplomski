void createFile() throws IOException{

    Path p = Paths.get("myPath.txt");

    Files.createFile(p);


}

void readFromFile() throws Exception {

    BufferedReader br = new BufferedReader(new FileReader(""));

    ArrayList<String> myStringArray = new ArrayList<>();

    myStringArray.add(br.readLine());

    br.close();

}