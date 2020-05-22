public Dvd findDvd(String title) {
    for (Dvd dvd : dvds) {          // loops through the whole list of dvds
        if (dvd.getTitle().equalsIgnoreCase(title)) {   // compares the dvd's title with the parameter title
            return dvd;  // if equal, return dvd
        }
    }
    return null;
}