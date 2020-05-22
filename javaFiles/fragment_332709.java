public class CustomComparator implements Comparator<String> {

    @Override
    public int compare(String str1, String str2) {

        int num1 = Integer.parseInt(str1.substring(1,str1.length()));
        int num2 = Integer.parseInt(str2.substring(1, str2.length()));

        return num1 - num2;

    }
}