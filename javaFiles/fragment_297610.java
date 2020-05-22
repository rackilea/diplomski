private boolean nameStartsWithThe(Artist a) {
    return a.getName().startsWith("The");
}

Set<Nationality> nationalities = album.getMusician()
                                 .filter(this::nameStartsWithThe)