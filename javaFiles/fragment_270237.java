public static void find(int[] a, int[] b, int[] acc)
{
    int a_index = 0, b_index = 0, acc_index = -1;
    int a_element, b_element;
    while (a_index < a.length && b_index < b.length)
    {
        a_element = a[a_index]; b_element = b[b_index];
        if (a_element == b_element)
        {
            acc = resize(acc);
            acc[++acc_index] = a_element;
            a_index++; b_index++;
        } else if (b_element < a_element) {
            b_index++;
        } else {
            a_index++;
        }
    }
    System.out.println(java.util.Arrays.toString(acc));
}