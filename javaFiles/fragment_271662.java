@RequestMapping(value = "/film", method = RequestMethod.GET, produces = "application/json")
public Film getFilm(@RequestParam("search") String search){
    FilmInfo filmInfo = new FilmInfo();
    Film film = filmInfo.getFilm(search);
    return film;
}