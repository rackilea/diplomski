import java.util.Scanner;

public class PalyndromeTest {
    static boolean isPalyndrome(String s, int shift) {
        int n = s.length();
        if(shift < 0) shift+=n;
        for(int pos = 0; pos < n/2; pos++) {
            if(s.charAt((pos+shift)%n) != s.charAt((n-pos-1+shift)%n))
                return false;
        }
        return true;
    }

    static int findShift(String s) {
        for(int shift = 0; shift <= s.length()/2; shift++) {
            if(isPalyndrome(s, shift) || isPalyndrome(s, -shift))
                return shift;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int count = s.nextInt();
        s.nextLine();
        for(int i=0; i<count; i++) {
            System.out.println(findShift(s.nextLine()));
        }
    }
}