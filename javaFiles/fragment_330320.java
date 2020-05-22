public static void main(String[] args) {

    int pyramidHeight = 3;
    for(int height=0; height<pyramidHeight; height++)
    {
        for(int width=height+1; width>0; width--)
        {
            System.out.print("-");
        }
        for(int width = 1 + (((pyramidHeight-1) - height) * 2); width>0; width--)
        {
            System.out.print("*");
        }
        System.out.println();
    }
}