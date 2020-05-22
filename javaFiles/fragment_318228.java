while(/* fancy argument */) {
    int counter; //you promised me this
    String argument; //and this

    List<Object> foo = data.get(counter); //find what is stored on the map  
    //and we don't need bar since we can play with foo

    if(foo == null) { //we have a new list we need to add
        foo = new ArrayList<>();
        data.set(counter, foo); //put it in the map
    }

    foo.add(argument); //add to list, don't need to re-put since it's already there
}