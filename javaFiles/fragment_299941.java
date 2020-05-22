public static void main(String[] args) {
    int rows=5;
    int i,j;
    for(i=1;i<=rows;i++)
    {
        /*print left side numbers form 1 to ...*/
        for(j=1;j<i;j++)
        {
            System.out.printf("%d", j);
        }


        /*Print the middle number*/
        System.out.printf("%d", i);


        /*print right numbers form ... to 1*/
        for(j=i-1;j>0;j--)
        {
            System.out.printf("%d", j);
        }
        System.out.println("");
    }

}