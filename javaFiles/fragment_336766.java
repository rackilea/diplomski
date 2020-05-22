public class SO {

    public void changeParams(int k, int[] A, String s){
        k++;
        A[0]++;
        s += "X";
    }
    public void print(){
        int k = 0;
        int[] A = {10, 20};
        String s = "aaa";
        changeParams(k, A, s);
        System.out.println(k + " " + A[0] + " " + s);
    }

    public static void main(String... args) throws Exception {
        new SO().print();
    }
}