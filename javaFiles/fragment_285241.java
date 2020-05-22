public class PersonalId { // ------------------- renamed: it was "personal_id"
    private int id = 0;   // ------------------- fixed: was "privete" instead of "private"
    private String name;
    public PersonalId(String name) { // ------------------- renamed: it was "personal_id"
        this.name = name; // ----------------- fixed: was "name = this.name"
        id++; // this line makes little sense, it's the same as declaring id = 1;
    }

    public int getId() {      // ------------------- added
        return this.id;       // ------------------- added
    }                         // ------------------- added
    public String getName() { // ------------------- added
        return this.name;     // ------------------- added
    }                         // ------------------- added
}