public void run() throws Exception {
    BufferedReader in = new BufferedReader(new FileReader(ReadRecords.class.getResource("/records.txt").getFile()));
    MyReader reader = new MyReader(in);
    int c;
    while( (c=reader.read()) != -1 ) { 
        System.out.print((char)c);
    }
    while( (c=reader.read()) != -1 ) { 
        System.out.print((char)c);
    }
    while( (c=reader.read()) != -1 ) { 
        System.out.print((char)c);
    }
    reader.close();
}