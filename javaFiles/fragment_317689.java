import java.util.HashMap;
...

    HashMap hm = new HashMap();
    for (int i = 0; i < array.length; i++) {
        Double key = new Double(array[i]);
        if ( hm.containsKey(key) ) {
            value = hm.get(key);
            hm.put(key, value + 1);
        } else {
            hm.put(key, 1);
        }
    }