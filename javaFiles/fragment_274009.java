public class Application extends Controller {


    public static void sum(Float num1, Float num2) {
        Float result = num1 * num2;
        render(result);
    }
}