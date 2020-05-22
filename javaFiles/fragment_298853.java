public void add(String s) 
{
    for(int i=store.length-1; i>=0; i--) { // note the change in the starting index
        if(store[i]==null) {
            store[i] = s;
            break;
        }
    } 
}