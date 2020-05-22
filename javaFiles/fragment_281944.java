Public Class B{
    ....
    public static void main(String[] args)
    {
        int[] b = new int[10];
        for(int i=0;i<10;i++){
            b[i] = A.DoSomething();
        }
    }
}