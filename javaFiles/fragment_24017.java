for(Iterator i = results.iterator(); i.hasNext();) {

    Object row = i.next();

    if (row instanceof User) {
       User u = (User) row; // this is safe
       // ...
    } else if (row instanceof Stuff) {
       Stuff u = (Stuff) row; // this is safe
       // ...
    }

 }