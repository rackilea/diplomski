public Object getEntry(Object k){
    for(int i=0; i<elems.length;i++)
        if(elems[i].key.equals(k)){
            return elems[i];     
        }
    return null;
}
public void update(Object k, Object v, Object newV){

    Object entry = getEntry(k)
    if (entry !=null){
       entry.setValue(newV);
    }


}