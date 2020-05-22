void function1(){
        if(redMarker ==null){
             redMarker = new Marker[array.length]; // added this line of code.
        }
        for(int i=0;i<array.length;i++){
            redMarker[i] = map.addMarker(.......);
        }   
    }