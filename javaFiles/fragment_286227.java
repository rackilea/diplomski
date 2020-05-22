public class TestRegEx2 {
    public static void main(String[] args) {
        Pattern pat = Pattern.compile("^(ABC) ?([0-9]{4}|[0-9]{6})?(?:(?:/)([0-9]{4}|[0-9]{6}))?(?:(?: ?XYZ ?)([0-9]{4}))?$");
        int count = pat.matcher("").groupCount(); // it turns out it doesn't matter what pattern you use here
        System.out.println("count : " + count);
    }
}