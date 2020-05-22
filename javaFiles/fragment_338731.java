public class test {
    public static void main(String ar[]) throws java.io.IOException {       

        String regex = "(\\.\\.[a-zA-Z0-9])([^\\.]*\\.[^\\.]+{2,}.*)([a-z]{2,}\\.\\.)";

        String useStr = "..aa.aaa..bb..";
        Pattern pattern = Pattern.compile(regex);

        Matcher match = pattern.matcher(useStr);
        while (match.find()) {          
            //String a = useStr.substring(match.start(), match.end());   
            String a = match.group(1) + match.group(2);  
            System.out.println(a);          
        }
    }
}