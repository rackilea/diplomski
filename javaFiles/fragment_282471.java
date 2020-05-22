public static void main(String[] args) throws IOException {
    // TODO Auto-generated method stub
    FileInputStream fstream = new FileInputStream("assignment2.txt");
    BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
    String strLine;

    //Read File Line By Line
    while ((strLine = br.readLine()) != null){
        // Print the content on the console
        System.out.println (strLine);
        String[] numbers = strLine.split(" ");
        for (String num : numbers){
            System.out.print(num + " ");
        }
        System.out.println("\n");
    }
    //Close the input stream
    br.close();
}