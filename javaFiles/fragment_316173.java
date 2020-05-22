for (User s : users) {
//if just one of my objects is librarian it will return true.
    if (s.getUserType() == User.enumUserType.LIBRARIAN) {
        return true;
     }    
}
return false;