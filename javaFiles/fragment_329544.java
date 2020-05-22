@Service
public class RandomEmailGenerator implements EmailGenerator {

    @Override
    public String generate() {
        return "feedback@yoursite.com";
    }
}