public void updateLengthAndGenre(String title, int length, String genre) {
    ArrayList<Film> output = new ArrayList<>();

    for (Film film : films) {
      if (film.getTitle().equals(title)) {
          film.setGenre(genre);
          film.setLength(length);
          return;
      }
    }

    films.add(new Film(title, length, genre));  // synchronize if you're multithreading
}