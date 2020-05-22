public class Split {
    public static void main(String[] args) {
        String [] tokens = "That's the code".split("[\\s']");
        for(String s:tokens){
            System.out.println(s);
        }
    }
}