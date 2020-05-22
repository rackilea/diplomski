public static void main(String[] args) throws IOException {
    //read text file
    CSVReader a = new CSVReader(new FileReader("test.txt"));
    //store text data into arraylist
    List<String[]> aa = a.readAll();
    //create 2D array LWD
    int LWD[][] = new int[aa.size()][2];
    //store data to array LWD
    for (int i = 0; i < aa.size(); i++) {
        for (int x = 0; x < aa.get(i).length-1; x++) {
            LWD[i][1] += Integer.parseInt(aa.get(i)[x].trim());
        }
        LWD[i][0] = i+1;
    }
    //display LWD
    for (int i = 0; i < aa.size(); i++) {
        System.out.print("[exam " + LWD[i][0] + "]");
        System.out.print("[LWD " + LWD[i][1] + "]");
        System.out.print("\n");
    }
}