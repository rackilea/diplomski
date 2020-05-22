for(int s=0;s<=y;s++){ // y mean number of arrays, user can input any number for y in here y>=2
    int w=s+1;
    System.out.println("number of data for array "+w+':');
    int night[][]=new int[s][x.nextInt()];
    for(int counter=0;counter<night.length;counter++){
        int m=counter+1;
        System.out.println("insert the number "+m+":");
        night[s - 1][counter]=x.nextInt();
    }
}