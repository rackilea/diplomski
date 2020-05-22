public class Test {

    public static String searchWord(String data, String first, String last) {
        //Some contains and null checks are needed here
        int start = data.indexOf(first) + first.length();
        int end = data.indexOf(last, start);
        return data.substring(start, end);
    }

    public static void main(String[] args) {
        String data = "nama:jono/umur:19/alamat:new york/phone:08123456";;
        System.out.println(searchWord(data, "nama:", "/"));
    }

}