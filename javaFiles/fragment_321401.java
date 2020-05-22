import java.util.Arrays;

public class Test {
    public static void main(String[] args){            
        int[] x = {0,1,4,7,8,9};
        System.out.println(matchArrays(x));
    }
    public static int matchArrays  (int[] x) {
        int[] y = {1,2,3,5,7,7,8};
        return (int)Arrays.stream(x).filter(i->Arrays.stream(y).anyMatch(j->j==i)).count();
    }
}