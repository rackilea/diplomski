for (i=0;i<myArray.length;i++){
        if(myArray[i] == null || myArray[i].length()==0){
                continue;
        }
        key=myArray[i].substring(0,myArray[i].indexOf("="));
        value=myArray[i].substring(myArray[i].indexOf("=")+1);
        this.hashmap.put(key,value);
    }