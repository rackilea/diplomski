//declare a map to hold your characters and their counters
 Map<String,Integer> charCounter = new HashMap<String,Integer>();
 //the following if else logic goes when you are looping through your tokens
    if(charCounter.containsKey(<your character>)){
           charCounter.put(<your character>,charCounter.get(<your character>)+1);
    }else{
          charCounter.put(<your character>,1);
    }