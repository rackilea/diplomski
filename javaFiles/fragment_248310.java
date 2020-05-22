class MyXHashMap{

    ...

    @Override
    public Set<Entry<K,V>> entrySet(){
      //override entrySet() to use your Entry class


    }


    static class MySimpleEntry<K,V> extends AbstractHashMap.SimpleEntry<K,V> implements Y {

       public MySimpleEntry(K key, V value){
           super(key,value);
       }
       ...
    }



}