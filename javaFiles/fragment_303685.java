public interface Service {
    public String run();
}

public class ExistingServiceImpl implements Service {

    @Override
    public String run() {
        throw new IllegalStateException("Muahahahaha!");
    }
}