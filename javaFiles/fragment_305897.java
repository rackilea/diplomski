public class Test {

    public static void main(String[] args) {
        String story = "Hello, I am strHost and I will be accompanied today by strHost1 and strHost2. As we walk through the mansion today, feel free to ask strHost1 or strHost2 any questions you may have.";
        String str = story.replaceAll("strHost1", "stringhost1");
        str = str.replaceAll("strHost2", "stringhost2");
        str = str.replaceAll("strHost", "stringhost");
        System.out.println(str);

    }
}