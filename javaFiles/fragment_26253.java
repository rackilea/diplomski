InputStream emailIn = (InputStream) message.getContent();
    Scanner s = null;
    try{
        s = new Scanner(emailIn).useDelimiter("\\A");
    while(s.hasNext())
        System.out.println(s.next());
    }
    finally{
        s.close();
    }