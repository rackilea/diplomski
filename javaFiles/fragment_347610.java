public void update(Object k, Object v, Object newV){
    ObjectDictionary ob = new ObjectDictionary(k,v);

    if (lookUp(k) !=null){
       ob.setValue(newV);
    }


}