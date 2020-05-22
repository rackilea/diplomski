for(Iterator<String> it = myList.iterator(); it.hasNext();){
    String s = it.next();
    for(char c : scrambled.toCharArray()){
        if(!s.contains(String.valueOf(c))){ 
            it.remove();
            break;
        }
    }
}