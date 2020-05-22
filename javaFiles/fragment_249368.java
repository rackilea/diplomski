public class ImageCache extends Hashtable {

    public Object get(Object key) {

        Object result = super.get(key);

        if (result == null){

            result = Toolkit.getDefaultToolkit().createImage((URL) key);
            put(key, result);
        }

        return result;
    }
}