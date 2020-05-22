public class Test {
    int[] Color = new int[2];
    int i = 20;
    public static void main(String[] args) {
        Test t = new Test();
        t.ChangeColor(new int[] {1,2,3});
        System.out.println(Arrays.toString(t.Color));
        System.out.print(t.i);

    }
    public  void ChangeColor(int[] value) 
    {
        Color = value;
        i = 10;
    }
}