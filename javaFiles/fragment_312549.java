@Service
public class Second {

    private final First first;

    public Second(ObjectProvider<First> first) {
        this.first = first.getIfAvailable(); // return null
    }

}