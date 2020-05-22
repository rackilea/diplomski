BufferedReader reader = null;
    try {
        while(true){ // break condition here
            reader = new BufferedReader ( new FileReader( "/myFilePath/file.txt" ) );
            String line;
            while( (line = reader.readLine()) != null ) {
                char[] chars = line.toCharArray(); // adding .replaceAll("\\(|\\)", "") for no ()
                for( char c : chars ) {
                    System.out.println(c);
                }
                Thread.currentThread().sleep( 5000 );
            }
        }
    } catch (IOException e) {
        // handle
    } catch( InterruptedException e ) {
        // handle
    } finally {
        try {
            reader.close();
        } catch (IOException e) {
            // handle
        }
    }