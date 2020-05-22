Process server = Runtime.getRuntime().exec(serverScript);
    BufferedReader in = new BufferedReader(new InputStreamReader(server.getInputStream()));
    if ( in.readLine().equals("listening...") ) {
        Process client = Runtime.getRuntime().exec(clientScript);

        String line;
        while ( (line=in.readLine()) != null )
            System.out.println("Read: " + line );
    }