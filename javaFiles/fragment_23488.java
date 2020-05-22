public static void tokenization() throws FileNotFoundException, IOException{

String msg;

int numberOfTotalTokens =0;
int numberOfMessages = 0;

String data = "E:\\Data\\SMSSpamCollection.txt";
// create a new output file output.txt
String outfilename = "E:\\output.txt"; 
File file =new File(outfilename);
file.createNewFile();

FileInputStream fisData = new FileInputStream(data);
BufferedReader readBufferData = new BufferedReader(new InputStreamReader(fisData));

// create a buffer writer tokDataB
FileWriter tokData = new FileWriter(outfilename,true);
BufferedWriter tokDataB = new BufferedWriter(tokData);

try{
    while ((msg =readBufferData.readLine()) != null) {
        int numberOfTokens = 0;
        StringTokenizer tokens = new StringTokenizer(msg);
        StringBuilder sb = new StringBuilder();
        System.out.println("Before: "+msg);

        System.out.print("After : ");
        while (tokens.hasMoreTokens()) {
            msg = tokens.nextToken();
            String msgLower = msg.toLowerCase();

            // write one token per line to output file
            tokDataB.write(msgLower);
            tokDataB.write("\n");

            numberOfTokens++;
            numberOfTotalTokens++; 
        }

        System.out.println("");
        System.out.println("Total Tokens: "+numberOfTokens);
        System.out.println("\n");
        numberOfTokens++;
        numberOfMessages++;
    }

    // close output writer
    tokDataB.close();                    

    System.out.println("Total Tokens: "+numberOfTotalTokens);
    System.out.println("Total Messages: "+numberOfMessages);
}
catch (Exception e){
    System.out.println("Error Exception: "+e.getMessage());
}