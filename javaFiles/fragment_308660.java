public class Test<K extends Number & Comparable<K>>{

    private K key;

    public boolean f (int i) {
        if (!(key instanceof Integer)) {
            return false;
        }
        return new Integer(i).compareTo((Integer)key) < 0;
    }

    public boolean g (K k){
        return k.compareTo(key) < 0;
    }
}