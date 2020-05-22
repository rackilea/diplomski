public static void main(String[] args) {
    HashMap< String, LinkedList<String> > hm = new HashMap< String, LinkedList<String> >();
    String line, key;
    LinkedList<String> lineSplit;

    try {
        BufferedReader br = new BufferedReader( new FileReader( new File("data.txt") ) );

        while( ( line = br.readLine() ) != null ){
            lineSplit = new LinkedList<String>( Arrays.asList(line.split(",")) );
            key = lineSplit.removeFirst();             
            hm.put(key, lineSplit);
        }
        br.close();

    } catch( IOException e ){
        e.printStackTrace();
    }
}