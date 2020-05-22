Map<K, V> array = new HashMap<K, V>();
for (Entry<K, V> entry : array.entrySet()) {
    // You have to explicitly call your callback. There is no "callback-syntax"
    // to the Java "foreach" loop
    System.out.println("key: " + entry.getKey());
    System.out.println("value: " + entry.getValue());
    //put your logic here...
}