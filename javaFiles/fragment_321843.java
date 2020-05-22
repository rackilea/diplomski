String[] constructArgs(Map mysqldArgs) {
    List strs = new ArrayList();
    strs.add(utils.files().getPath(getMysqldFilePointer()));

    //The magic happens here 
    strs.add("--defaults-file=mysql\\my.ini");
    if (isWindows()) {
        strs.add("--console");
    }
    Iterator it = mysqldArgs.entrySet().iterator();
    while (it.hasNext()) {
        Map.Entry entry = (Map.Entry) it.next();
        String key = (String) entry.getKey();
        String value = (String) entry.getValue();
        StringBuffer buf = new StringBuffer("--");
        buf.append(key);
        if (value != null) {
            buf.append("=");
            buf.append(value);
        }
        strs.add(buf.toString());
    }

    return utils.str().toStringArray(strs);
}