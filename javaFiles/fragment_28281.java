public static void main(String[] args) throws Exception {
    ChatClient chatclient = new ChatClient("wss://thomas.localnetwork.com:65120/wsserver?userId=Thomas", "Thomas", "1", "1", "L");

    chatclient.connectBlocking();

    BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );
    while ( true ) {
        String line = reader.readLine();
        if( line.equals( "close" ) ) {
            chatclient.closeBlocking();
        } else if ( line.equals( "open" ) ) {
            chatclient.reconnect();
        } else {
            chatclient.send( line );
        }
    }
}