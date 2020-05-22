public boolean add(String content){ 
    if(size == strings.length) { 
        String[] temp_list = new String[strings.length]; //no need to allocate a new array here if this is just to store your current array
        temp_list = strings; 
        strings = new String[size++]; //wrong, this allocates a `size`-long array and increases `size` by 1 afterwards, rather than create a new, larger internal array
        strings = temp_list; //this just overwrites your internal array with the old array which is not increased in size

     } 
     for(int i = 0; i < strings.length; i++) { 
         if(strings[i] == null) { //this is not necessary with proper `size`
             strings[i] = content; 
         } 
     } 
     return true; 
}