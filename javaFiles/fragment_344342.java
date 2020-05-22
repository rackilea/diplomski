private static Films getTopFilm(Films[] f, int yearEntered) {
        Films topFilm = null;
        double max = 0;
        for (int i = 0; i < f.length; i++) {
            if (f[i].getPremiereYear() != yearEntered) {
                continue;
            }
            if (f[i].getFilmIncome() > max) {
                topFilm = f[i];
                max = f[i].getFilmIncome(); // you forget to set the value of max.
            }
        }
        return topFilm;
    }