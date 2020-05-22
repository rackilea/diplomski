public class bst
{
    public static void print_leaves(int[] preorder)
    {
        if (preorder.length == 1)
        {
            System.out.println(preorder[0]);
        }
        else if (preorder.length > 1)
        {
            print_leaves(preorder, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
    }

    public static boolean is_in_range(int min, int v, int max)
    {
        return min < v && v < max;
    }

    public static int print_leaves(int[] preorder, int i, int min, int max)
    {
        boolean in_range = is_in_range(min, preorder[i], max);
        if (i > 0 && (i == preorder.length-1 || !in_range))
        {
            if (!in_range) System.out.println(preorder[i-1]);
            if (i == preorder.length - 1) System.out.println(preorder[i]);
            return i;
        }

        boolean b = preorder[i+1] > preorder[i];
        int next = print_leaves(preorder, i+1, b ? preorder[i] : min, b ? max : preorder[i]);
        if (next == preorder.length-1 || !is_in_range(min, preorder[next], max))
        {
            return next;
        } 
        return print_leaves(preorder, next, min, max);
    }

    public static void main(String[] argv)
    {
        int[] preorder1 = { 890, 325, 290, 530, 965 };
        int[] preorder2 = { 100, 50, 25, 30, 29, 28, 75, 80, 200, 150, 250 };
        int[] preorder3 = { 0 };
        int[] preorder4 = { 100, 0, 200 };
        int[] preorder5 = { 100, 200 };
        int[] preorder6 = { 100, 50 };
        print_leaves(preorder1);
        System.out.println();
        print_leaves(preorder2);
        System.out.println();
        print_leaves(preorder3);
        System.out.println();
        print_leaves(preorder4);
        System.out.println();
        print_leaves(preorder5);
        System.out.println();
        print_leaves(preorder6);
    }
}