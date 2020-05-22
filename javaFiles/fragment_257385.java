@Controller
public class NumberController {
    public int randomSkaicius() {
        Random rand = new Random();
        int skaicius = (int) (Math.random() * 50 + 1);
        return skaicius;
    }
}