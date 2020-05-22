public class Test {

    public static void main(String[] args){
        String[] strings = {"foo 11 25","foo 67 45 97",
        "foo 38 15 976 24"};

        for(String string : strings) {
            ArrayList<Integer> numbers = new ArrayList<Integer>();
            Matcher matcher = Pattern.compile("[a-z]+\\s((?:\\d+\\s?)+)").matcher(string);
            matcher.find();
            String[] nums = matcher.group(1).split("\\s");
            for(String num : nums){
                numbers.add(Integer.valueOf(num));
            }
            System.out.println("Match from string: "+ "\""+ string + "\"" + " : " + numbers.toString());
        }
    }
}