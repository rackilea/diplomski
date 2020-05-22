/* file DogOnTv.java */
public class DogOnTv extends CleverDog {

    String fictionalName;

    public DogOnTv(String realName, String fictionalName) {
        super(realName);
        fictionalName = fictionalName;
    }

    public String getName() {
        return fictionalName;
    }

}