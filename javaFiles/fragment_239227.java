TestTest test = new TestTest();
        List<List<Object>> data = new ArrayList<List<Object>>();

        int loop;

        for( loop = 0; loop < 100; loop = loop + 10 ){
            List<Object> dataitem = new ArrayList<>();
            dataitem.add( "hallo" );
            dataitem.add( loop );
            data.add( dataitem );
        }

        test.setData( data );

        ObjectMapper mapper = new ObjectMapper();
        String jackson = mapper.writeValueAsString( test );

        System.out.println( new Gson().toJson( test ) );
        System.out.println( jackson );