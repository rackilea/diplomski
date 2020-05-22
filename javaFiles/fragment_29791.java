public class add {
    public static void main(String[] args) {
        int ans;
        input in = new input();
        //here you can set value at a and b to the other class
        in.readAandB();

        //now you get make your operation
        ans = in.a + in.b;
        System.out.println("result = " + ans);
    }
}