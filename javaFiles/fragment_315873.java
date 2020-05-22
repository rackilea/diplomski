import java.util.regex.*;
class HelloWorld{

     public static void main(String []args){

     String str = "THE_HUIGE_STRING_THAT_CAUSED_Body is limited to 30000 characters;you entered 53501_ISSUE";
     str = new StringBuilder(str).reverse().toString();
     String rx = "\"?[^\"]*\"?\\s*\"?[^\"\\n\\r]*(?:xxt|XXT)[^\"\\n\\r]*(?![^\"]*\":\"erutcip\")";
     Pattern ptrn = Pattern.compile(rx);
     Matcher m = ptrn.matcher(str);
     while (m.find()) {
         System.out.println(new StringBuilder(m.group(0)).reverse().toString());
     }

     m = ptrn.matcher(new StringBuilder("\"something-txx\": \"somerandomstring\"").reverse().toString());
     while (m.find()) {
        System.out.println(new StringBuilder(m.group(0)).reverse().toString());
     }
  }
}