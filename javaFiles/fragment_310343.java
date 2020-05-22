@ManagedBean
@ViewScoped
public class NewMusician {

    private ArrayList<Musician> musicians = new ArrayList<Musician>();

    public NewMusician() {
        musicians.add(new Musician("olo"));
    }

    public ArrayList<Musician> getMusicians() {
        return musicians;
    }

    public void saveNewMusician() {
        // ...
    }

    // ...
}