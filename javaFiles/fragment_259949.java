for (String shortstr : categoryList) {
    String[] splitstr = shortstr.split(',');
    for (String innershort: splitstr) {
        short layerValue = Short.parseShort(innershort.trim());
        // add it to a list
    }
}