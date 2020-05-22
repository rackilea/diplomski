package stackoverflow.q_24933319;

public class FindLength {
    public static void main(String[] args) {
        String[] arr = {"abc","bgfgh","gtddsffg"};
        System.out.println("Array size is: " + arr.length);
        for(String s : arr) {
            System.out.println("Value is " + s + ", length is " + s.length());
        }
    }
}

//Output:
//Array size is: 3
//Value is abc, length is 3
//Value is bgfgh, length is 5
//Value is gtddsffg, length is 8