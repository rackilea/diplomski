public class User {

    String id;
    int value;
    String Anime;

    .
    .
    .
    //Getter Setter 
    .
    .
    .

    @Override
    public String toString() {
        return "{" +
            "id=" + id + "," +
            "value=" + value + ","+
            "Anime='" + Anime +
            "}";
    }

}