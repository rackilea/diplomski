// ... omitting beginning
try {
    FileWriter fileWriter = new FileWriter ("Sorted output.txt");
    //BufferedWriter bufferedWriter = new BufferedWriter (fileWriter);
    PrintWriter out = new PrintWriter (new FileWriter("Sorted output.txt", true));
    do { 
// ... omitting rest