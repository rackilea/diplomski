@Controller
public class NumberController {
    @GetMapping("/my/page")
    public ModelAndView getMyPage() {
        return new ModelAndView("my-page", "randomSkaicius", randomSkaicius());
    }

    public int randomSkaicius() {
        Random rand = new Random();
        int skaicius = (int) (Math.random() * 50 + 1);
        return skaicius;
    }
}