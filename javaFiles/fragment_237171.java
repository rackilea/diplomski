try {
    BufferedReader br = new BufferedReader(new FileReader( "newoutfile.txt"));
    // String line;
    while( ( line = br.readLine() ) != null ) {
        String[] value = line.trim().split(",");

        System.out.println("the array" + Arrays.toString(value));
        int rows = ( value.length / 5);
        for ( int i = 0; i < rows; i++) {
           String personid = value[ i * 5 ];
           String first_name = value[ i * 5  + 1 ];
           String last_name = value[ i * 5 + 2 ];
           String street = value[ i * 5  + 3 ];
           String city = value[ i * 5  + 4 ];
           connection.createStatement().execute(
                "insert into person10(personid,first_name,last_name,street,city)values('"
                        + personid + "','" + first_name + "','"
                        + last_name + "','" + street + "','"
                        + city + "')");
        }
    }