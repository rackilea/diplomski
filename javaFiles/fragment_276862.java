public class Entry implements Comparable {

    String nom;
    String email;
    double note;

    public Entry(String nom, String email, Double note) {
        this.nom = nom;
        this.email = email;
        this.note = note;
    }

    @Override
    public int compareTo(Object o) {
        if(!(o instanceof Entry)) throw new IllegalArgumentException("Wrong type!");

        Entry other = ((Entry) o);

        if(this.note > other.note) return 1;
        if(this.note == other.note) return 0;
        return -1;
    }
}