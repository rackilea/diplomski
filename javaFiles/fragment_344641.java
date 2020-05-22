private static final int BUFFER_SIZE = 1024;

// Encapsulate the read process
private String readData(Reader reader) throws IOException {
    StringBuilder result = new StringBuilder(); 
    char[] buffer = new char[BUFFER_SIZE];  // [note1]
    while (reader.ready()) { // [note2]
        int charsRead = reader.read(buffer,0,BUFFER_SIZE-1));
        if (charsRead > 0) {
            result.append(buffer,0,charsRead);
        }
    }
    return result.toString();
}

public void readStuff() { 
    try {
        Socket s = new Socket("195.211.49.6", 5222);

        PrintWriter out = new PrintWriter(s.getOutputStream());
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(s.getInputStream()));
        out.println("<stream:stream to='nimbuzz.com' xmlns='jabber:client' xmlns:stream='http://etherx.jabber.org/streams' version='1.0'>");
        out.flush();

        // Read out the data and print it to the console
        System.out.println(readData(bufferedReader));

        // Second request over the same socket
        out.println("<iq type='set' xml:lang='en' id='terms' to='nimbuzz.com'><query xmlns='jabber:iq:auth'><username>username</username><password>password</password><resource>resource</resource></query></iq>");
        out.flush();

        // Read out the answer for the second result
        System.out.println(readData(bufferedReader));


    } catch (UnknownHostException e) {
        e.printStackTrace();
    } catch (IOException e) {
        // TODO Auto-generated catch block
         e.printStackTrace();
    } catch (Exception e) {
        System.out.println(e.getLocalizedMessage());
    }
}