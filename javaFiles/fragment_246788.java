import java.util.ArrayList;

public class Test {
    public static ArrayList<String> permute(String prefix, String s){
        int len = s.length();
        ArrayList<String> list = new ArrayList<String>();
        if(s.length() == 0)
            list.add(prefix);
        else
            for(int i = 0; i < len; i++)
                list.addAll(permute(prefix + s.charAt(i), s.substring(0, i) + s.substring(i+1, len)));
        return list;
    }
    public static void main(String[] args) {
        String str = "abcd";
        ArrayList<String> array = permute("", str);
        System.out.print(array.size());
    }
}