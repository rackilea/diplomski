@SuppressWarnings("unchecked")
public static <A> A fromXML(Class c, File file) {
    // Don't ever try to use DomDriver. They are VERY slow.
    XStream xStream = new XStream();
    InputStream inputStream = null;
    Reader reader = null;

    try {
        inputStream = new java.io.FileInputStream(file);
        reader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
        Object object = xStream.fromXML(reader);

        if (c.isInstance(object)) {
            return (A)object;
        }
    }
    catch (Exception exp) {
        log.error(null, exp);
    }
    finally {
        if (false == close(reader)) {
            return null;
        }
        if (false == close(inputStream)) {
            return null;
        }
        reader = null;
        inputStream = null;
    }

    return null;
}