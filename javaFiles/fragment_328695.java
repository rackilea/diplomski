InputStream is = // obtain the original gzip stream

    GZIPInputStream gis = new GZIPInputStream(is);
    Reader reader = new InputStreamReader(gis);

    //... proceed reading and so on