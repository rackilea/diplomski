Settings settings = new Settings();
    settings.maxWidth = 2048; //modify if needed
    settings.maxHeight = 2048; //modify if needed
    settings.fast = true; //fast should be fine here!
    //all tiles have a 1px padding. better for not getting artifacts
    TiledMapPacker pack = new TiledMapPacker();
    try
    {
        pack.processMaps(
                new File(
                        "PATH-TO-INTPUT"),
                new File(
                        "PATH-TO-OUTPUT"),
                settings);
    }
    catch (IOException e)
    {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }