ListIterator<Film> filmIter = films.listIterator();
while(filmIter.hasNext()){
    if( /* some condition */){
        fillmIter.add(new Film(title, length, genre));
    }
    filmIter.next(); // example only.
}