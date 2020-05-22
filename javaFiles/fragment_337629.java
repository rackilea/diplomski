public class Test {
    public static void main(String args[]) {
        String input="# should be O: 0.00, A: 0.45, B: 0.35, AB: 0.20";
        Pattern pattern = Pattern.compile("[0-9].[0-9]{2}");
        Matcher m = pattern.matcher(input);
        int i=0;
        while (m.find()) {
            String str = m.group();
            double value = Double.parseDouble(str);
            System.out.println( "#"+ i + " " + value);
            i++;
        }
    }
}