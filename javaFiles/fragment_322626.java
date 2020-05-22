ProcessBuilder pb = new ProcessBuilder( "/bin/cat", "some.file" );
    Process process = pb.start();
    InputStream is = process.getInputStream();
    int c;
    while( (c = is.read()) != -1 ){
        System.out.print( (char)c + "-" );
    }
    process.waitFor();