while(it.hasNext()) {
    Person line = it.next();
    //call a method which checks that all values have been set 
    if (thatMethodReturnsTrue){
        output.push(line);
    } else{
      throw SomeException();
    }
}