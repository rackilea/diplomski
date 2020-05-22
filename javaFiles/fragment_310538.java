public class Genre implements Comparable<Genre>{

    String name;

    public Genre(String name) {
        super();
        this.name = name;
    }

    @Override
    public int compareTo(Genre otherGenre) {
        return name.compareTo(otherGenre.name);
    }

    @Override
    public String toString() {
        return name;
    }

}