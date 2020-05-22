public class TestRegEx1 {
    public static void main(String[] args) {
        Pattern pat = Pattern.compile("^(ABC) ?([0-9]{4}|[0-9]{6})?(?:(?:/)([0-9]{4}|[0-9]{6}))?(?:(?: ?XYZ ?)([0-9]{4}))?$");
        try {
            Field groupCount = Pattern.class.getDeclaredField("capturingGroupCount");
            groupCount.setAccessible(true);
            int count = ((Integer) groupCount.get(pat)) - 1;
            System.out.println("count : " + count);
        } catch (Exception e) { }
    }
}