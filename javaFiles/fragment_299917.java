public static String getString(Clob data) throws SQLException {

    StringBuilder sb = new StringBuilder();
    char[] cbuf = new char[8192];
    int l = 0;
    try (Reader r = data.getCharacterStream()) {
        while ((l = r.read(cbuf)) > -1) {
            sb.append(cbuf, 0, l);
        }
    } catch (IOException ioe) {
        throw new SQLException("Unable to read character stream from Clob.", ioe);
    }
    return sb.toString();
}