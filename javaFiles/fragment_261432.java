public class Tree {

    public static final void main(String[] args)
    {
        int n = 10;
        for(int i = 0; i < n; ++i)
        {
            for(int j = 0; j < n-i; ++j)
                System.out.print(" ");
            for(int k = 0; k < i*2-1; ++k)
                System.out.print("*");

            System.out.println();

        }
    }
}