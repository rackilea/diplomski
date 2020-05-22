private ZipEntry getZipEntry(String name, long jzentry) {
    ZipEntry e = new ZipEntry();
    e.flag = getEntryFlag(jzentry);  // get the flag first
    if (name != null) {
        e.name = name;
    } else {
        byte[] bname = getEntryBytes(jzentry, JZENTRY_NAME);
        if (!zc.isUTF8() && (e.flag & EFS) != 0) {
            e.name = zc.toStringUTF8(bname, bname.length);
        } else {
            e.name = zc.toString(bname, bname.length);      // Line 529
        }
    }
    /* snip */
    return e;
}