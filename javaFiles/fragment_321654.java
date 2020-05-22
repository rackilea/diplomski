final FilmList filmList = new FilmList();
filmList.setShowLocation("Your location");
filmList.setScreenWeek("Screen week");
filmList.addFilm(filmInstance);

System.out.println(filmList.searchFilm().toString());