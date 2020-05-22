public class PatternExample {

    public static void main(String[] args) {
        String split = "The Lazy dog is running fast";
        String word = "dog";
        String tmp = split;
        while (tmp.contains(word)){
            int x = tmp.indexOf(word);
            System.out.println(tmp.substring(0,x));
            System.out.println(word);
            tmp = tmp.substring(x+word.length());
        }
        System.out.println(tmp);
    }
}