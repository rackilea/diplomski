while(/* fancy argument */) {
    int counter; //you promised me this
    String argument; //and this

    Object[] foo = data.get(counter); //find what is stored on the map  
    Object[] bar; //our expected result

    if(foo == null) { //create a new array and append it
        bar = new Object[1];
        bar[0] = argument;
    }
    else { //fill the new array
        bar = new Object[foo.length+1];
        for(int i = 0; i < foo.length; i++) {
            bar[i] = foo[i];
        }
        bar[foo.length] = argument;
    }

    data.set(counter, bar); //put the updated array into the map
}