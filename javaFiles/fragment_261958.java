public class Sample {

public static void main(String[] args) {
    String str = "apple banana carrot";
    System.out.println(separatingWords(str));
 }

public static String separatingWords(String str) {
    String result = str.replaceAll(" ", "-");
    return result;
 }
}