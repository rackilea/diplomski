public class Reg {

    public static void main(String[] args){

        String s = "abc1";
        Pattern p = Pattern.compile("\\d");
        Matcher m = p.matcher(s);
        String no = new String();

        while (m.find()){

              no = m.group();
        }

        String newStr = s.replace(no, "hi");
        System.out.println(newStr);
       }
}