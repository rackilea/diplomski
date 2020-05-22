import java.util.*;

class Test {
    public static void main(String[] args) {
        List<String> keyWords = new ArrayList<>();
        Scanner scanKeyWords = new Scanner(System.in);
        for(;;) {
            String next = scanKeyWords.next();
            if("0".equals(next)) {
                break;
            }
            // if you put keyWords.add(scankeyWords.nextLine()) here, it will not work.
            keyWords.add(next);
        }
        System.out.println(keyWords.toString());
    }
}