public class Film {
    private String director;
    private String filmName;
    private String leadActor;

    public Film(String director, String filmName, String leadActor) {
        this.director = director;
        this.filmName = filmName;
        this.leadActor = leadActor;
    }

    public String getFilmName() {
         return filmName;
    }

    public void setFilmName(String filmName) {
         this.filmName = filmName;
    }

    public String getDirector() {
         return director;
    }

    public void setDirector(String director) {
         this.director = director;
    }
    public String getLeadActor() {
         return leadActor;
    }

    public void setLeadActor(String leadActor) {
         this.leadActor = leadActor;
    }
}