Scanner sc = new Scanner(System.in);
    ArrayList<Integer> list=new ArrayList<>();  
    while(sc.hasNext()){
        list.add(sc.nextInt());
    }
    int[] store = new int[list.size()];
    int k=0;
    for(int i:list){
        store[k++]=i;
    }