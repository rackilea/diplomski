public static void main(String[] args) throws Exception {
    String inputFileName="C:\\MFile";


    ArrayList<String> fileLines = new ArrayList<String>();
    FileReader fr;
    BufferedReader br;

    // Time
    int t = 1;


    fr = new FileReader(inputFileName);
    br = new BufferedReader(fr);
    String line;


    while ((line=br.readLine())!=null) {
     fileLines.add(line);
    }

    AvgVar myVar = new AvgVar(fileLines);

    for(t=1; t<10; t++){ 
    System.out.print("Average Var at Time t=" + t + " = " + myVar.avgVar(t)+"\n");