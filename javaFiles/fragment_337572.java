public class SpiralMatrix {

public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);

    int size=sc.nextInt();
    int[][] arr=new int[size][size];
    int r,c;
    int elements =size*size;

    for(int i=0;i<size;i++)
        for(int j=0;j<size;j++)
            arr[i][j]=sc.nextInt();

    int count=0;

    int left=-1,down=1,right=2,up=-2;

    if(size%2==0) {r=size/2-1; c=size/2;}       
    else r=c=size/2;
    System.out.print(arr[r][c]+" ");

    try{
    while(count<elements-1){
    for(int i=0;i>left;i--){
        c=c-1;
        System.out.print(arr[r][c]+" ");
        count++;
    }

    for(int i=0;i<down;i++){
        r=r+1;
        System.out.print(arr[r][c]+" ");
        count++;
    }

    for(int i=0;i<right;i++){
        c=c+1;
        System.out.print(arr[r][c]+" ");
        count++;
    }

    for(int i=0;i>up;i--){
        r=r-1;
        System.out.print(arr[r][c]+" ");
        count++;
    }

    left=left-2;
    down=down+2;
    right=right+2;
    up=up-2;

    }

    }catch(ArrayIndexOutOfBoundsException e){}

    }