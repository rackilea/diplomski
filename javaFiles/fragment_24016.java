for(Iterator i = results.iterator(); i.hasNext();) {

    Object row = i.next();

    if (row instanceof User) {
       User u = (User) row; // this is safe
       // ...
    }

 }