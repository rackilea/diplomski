public class Test {
    public static void main(String[] args) throws Exception {
        double div = (double)4/3;  
        float theta = (float) Math.toDegrees(Math.atan(div));
        System.out.println(theta); // 53.130104
    }
}