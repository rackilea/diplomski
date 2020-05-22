Scanner read = new Scanner(System.in);
int[] tab = new int [100];
int idx=0;
do{
    System.out.println("Number for array idx "+idx);
    try{
        tab[idx] = read.nextInt();
    }catch(Exception e){
        System.out.println("Wrong input");
    }
    if(tab[idx]<0) break;
    idx++;
}while(idx<100)