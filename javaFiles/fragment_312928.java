Set<String> ht = new HashSet<String>();

for (int i = 0; i<20; i++){
    if ( !ht.add(String.valueOf(i%10)) ) {
       //it already existed, throw an exception or whatever
    }
}