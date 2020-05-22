@Stateless
public class TestEjbImpl implements TestEjb {

    @Override
    public String something() {
        return "Hello world";
    }
}