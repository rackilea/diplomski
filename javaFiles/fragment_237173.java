try {
    BufferedReader br = new BufferedReader(new FileReader( "newoutfile.txt"));
    // String line;
    while( ( line = br.readLine() ) != null ) {
        String[] value = line.trim().split(",");

        System.out.println("the array" + Arrays.toString(value));
        int rows = ( value.length / 5);
        for ( int i = 0; i < rows; i++) {
           connection.createStatement().execute(
                "insert into person10(personid,first_name,last_name,street,city)values('"
                        + value[ i * 5 ] + "','" + value[ i * 5  + 1 ] + "','"
                        + value[ i * 5 + 2 ] + "','" + value[ i * 5  + 3 ] + "','"
                        + value[ i * 5  + 4 ] + "')");
        }
    }