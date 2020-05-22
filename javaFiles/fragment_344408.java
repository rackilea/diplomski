public class SameSignatureMethods {
    public  <T extends String> String test() {
        return null;
    }

    public  <T extends Double> Double test() {
        return null;
    }

    public static void main(String[] args) {
        System.out.println(new SameSignatureMethods().<Double>test());
    }
}