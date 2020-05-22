Iterator it = list.iterator(); 
while(it.hasNext()){
    Object o = it.next();
    if(someCondition(o)){
        it.remove();
    }
}