for (Object row : results) {
    if (row instanceof User) {
       User u = (User) row; // this is safe
       // ...
    }
}