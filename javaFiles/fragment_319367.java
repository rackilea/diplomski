for(Film film : films){
    film.printFilmName();
    filmName = film.getFilmName();               // <-- Added this.
    if(inputFilmName.equals(filmName)){          // <-- So that this works.
        foundFilm = true;
        tempFilm = film;
        System.out.println("Found film name");
        break;
    }
}