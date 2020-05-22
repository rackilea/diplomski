int[] getArray(){        
    Scanner in=new Scanner(System.in);
    int size;
    System.out.print("\nEnter the size : ");
    size=in.nextInt();
    int[]arr=new int[size];
    System.out.print("\nEnter the elements one by one : ");
    for(int i=0;i<size;i++){
        arr[i]=in.nextInt();
    }
    return arr;
}