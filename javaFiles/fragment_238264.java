public boolean add(String content){
    boolean add = false; //unnecessary, can replace bottom `add` with `false` for same result
    strings = new String[10]; //overwrites internal array of "list" with a new array
    for(int i = 0; i < strings.length; i++){
        if(strings[i] == null) { //will always replace only first element as this is a new array
            strings[i] = content;
            return true;
        }
    }
    return add;
}