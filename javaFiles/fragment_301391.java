public void delete(Person p) {
    boolean alreadyExist = false;
    ListIterator definitelyNotLIter = lList.listIterator();
    while(definitelyNotLIter.hasNext()) {        
        Person current = definitelyNotLIter.next();      
        if (p.equals(current)) {
            alreadyExist = true;
            definitelyNotLIter.remove();

            // Option 1:
            break;  // next line to execute will be the if(alreadyExist) block

            // Option 2:
            // put your successful delete logging here
            // return;
            // and leave the failed delete logging outside the loop

            // Option 3:
            // Do nothing. The looping will continue, and you'd have a deleteAll method, where multiple items would get deleted if you managed to get duplicates in the list.
            // You actually wouldn't need alreadyExist any more.

            // I'd go with option 1, myself
        }
    }
    if(alreadyExist) {
        System.out.println("Person: " + p + " is deleted from the list."); // p.toString() will get called
    }
    else {
        System.out.println("Person: " + p + " is not on the list."); // p.toString() will get called
    }
}