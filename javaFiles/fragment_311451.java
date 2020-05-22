import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SplitString {
    public static void main(String[] args){
        String input = "<input type=\"hidden\" name=\"SYNCHRONIZER_TOKEN\" value=\"2f56248e-e54d-48ef-8c8c-6028d6f3d63f\" id=\"SYNCHRONIZER_TOKEN\" />\n";
        Pattern pattern = Pattern.compile("value=\"[a-zA-Z0-9-]+\"");
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()){
            String keyValue = matcher.group(0);
            String key = keyValue.split("=")[0];
            String value = keyValue.split("=")[1];
            System.out.println("KeyValue: " + keyValue);
            System.out.println("Key: " + key);
            System.out.println("Value: " + value);
        }
    }
}