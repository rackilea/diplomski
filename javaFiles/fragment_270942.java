public boolean idValidate(int id) {
    for (Item i : items) 
        if (i.getId() == id) 
            return true; // stop as soon as one is true.
    return false;
}