public class Test
{
    public static String seeColor (String color) {
        if (color.startsWith("red")) return "red";
        if (color.startsWith("blue")) return "blue";
        return "";
    }

    public static void main(String[] args) {
        String[] testData = { "redxx", "xxred", "blueTimes", "NoColor",
            "red", "re", "blu", "blue", "a", "", "xyzred" };
        for (String s: testData)
            System.out.println("[" + s + "] -> [" + seeColor(s) + "]");
    }
}