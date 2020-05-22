Properties credentials = Optional.of(new Properties())
    .map(p -> {
             try
             {
                p.load(new FileInputStream("credentials.properties"));
             }
             catch (IOException ex) {}
             return p;
         })
    .get();