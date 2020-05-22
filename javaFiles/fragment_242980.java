class Diagonal
{
    public static void main(String[] args)
    {
        int r=3,c=4;
        int Mat[][]={{1,2,3,4},{5, 6 ,7 ,8},{9,10,11,12}};
        int x,y;
        for(int i=0;i<c;i++)
        {
            y=i;x=0;
            System.out.print("[");
            while(y>=0 && x<r)
            {
                System.out.print(Mat[x][y]+" ");
                x++;y--;
            }
            System.out.print("] ");
        }

        for(int i=1;i<r;i++)
        {
            x=i;y=c-1;
            System.out.print("[");
            while(x<r)
            {
                System.out.print(Mat[x][y]+" ");
                x++;y--;
            }
            System.out.print("] ");
        }

    }
}