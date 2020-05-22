try {
            String input= "D:\\input.txt";
            BufferedReader in = new BufferedReader( new FileReader( input ) );

            String output = "D:\\output.txt";
            BufferedWriter out = new BufferedWriter( new FileWriter( output ) );

            String inputLine = "";

            while ( ( inputLine = in.readLine( ) ) != null ) {
                if ( inputLine.contains( "Windows" ) ) {
                    out.append( inputLine );
                    out.newLine( );
                }
            }

            in.close( );
            out.flush( );
            out.close( );
        } catch ( Exception e ) {
        }