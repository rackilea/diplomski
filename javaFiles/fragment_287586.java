// Thread reader class adapted from
// http://www.javaworld.com/article/2071275/core-java/when-runtime-exec---won-t.html
public class InputReaderThread extends Thread {
    // input stream
    InputStream is;
    // name
    String name;
    // is there data?
    boolean hasData = false;
    // data itself
    StringBuilder data = new StringBuilder();


    // constructor
    public InputReaderThread(InputStream is, String name) {
        this.is = is;
        this.name = name;
    }

    // set if there's data to read
    public synchronized void setHasData(boolean hasData) {
        this.hasData = hasData;
    }

    // data available?
    public boolean hasData() { return this.hasData; }

    // get the data
    public StringBuilder getData() {
        setHasData(false);  // clear flag
        StringBuilder returnData = this.data;
        this.data = new StringBuilder();

        return returnData;
    }

    @Override
    public void run() {
        // input reader
        InputStreamReader isr = new InputStreamReader(this.is);
        Scanner sc = new Scanner(isr);
        // while data remains
        while ( sc.hasNextLine() ) {
            // print out and append to data
            String line = sc.nextLine();
            System.out.println(this.name + " >> " + line);
            this.data.append(line + "\n");
        }
        // flag there's data available
        setHasData(true);
    }
}