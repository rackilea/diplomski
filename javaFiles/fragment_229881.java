public static void read(int timestamp,int range) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("LOG_TEST"));
    String line;
    CircularFifoQueue<String> prevLines = new CircularFifoQueue<>(range);
    int currTimestamp;
    while ((line = br.readLine()) != null) {            
        currTimestamp = Integer.parseInt(line.split("\\s+")[3]);
        if (currTimestamp >= timestamp) {
            for (String prevLine : prevLines) {  //prints the range previous lines
                System.out.println(prevLine);
            }
            System.out.println(line);            //prints the current line
            for(int i = 0; i<range;i++){         //prints the following range lines
                System.out.println(br.readLine());
            }                
            break;
        } else {
            prevLines.add(line);
        }
    }
    br.close();
}