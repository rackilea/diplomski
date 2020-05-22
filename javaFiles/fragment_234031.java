private void store0(BufferedWriter bw, String comments, boolean escUnicode)
    throws IOException
{
    if (comments != null) {
        writeComments(bw, comments);
    }
    bw.write("#" + new Date().toString());
    bw.newLine();
    synchronized (this) {
        for (Enumeration<?> e = keys(); e.hasMoreElements();) {
            String key = (String)e.nextElement();
            String val = (String)get(key);
            key = saveConvert(key, true, escUnicode);
            /* No need to escape embedded and trailing spaces for value, hence
             * pass false to flag.
             */
            val = saveConvert(val, false, escUnicode);
            bw.write(key + "=" + val);
            bw.newLine();
        }
    }
    bw.flush();
}