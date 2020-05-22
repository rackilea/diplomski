keyStore = keyStore.getinstance();

    if((keyStore != null) && (kspath != null)) {
       File ksFile = new File(kspath);

       FileInputStream is = new FileInputStream(ksFile);

       keyStore.load(is, kspw.toCharArray());
    }