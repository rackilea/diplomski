public class Solution {

    public static void main(String[] args) {
        String binary = Integer.toBinaryString(67); 
        System.out.println(binary);
        Pattern pattern = Pattern.compile("0+|1+");
        Matcher matcher = pattern.matcher(binary);
        while (matcher.find()) {
            System.out.println(matcher.group(0));
        }
    }

}