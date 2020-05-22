import javax.inject.Inject;

public class Zoo {

    @Inject
    private Dog dog;

    public Zoo() {
    }

    public void talk() {
        dog.talk();
    }
}