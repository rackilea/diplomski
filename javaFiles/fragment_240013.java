ArrayList<Integer>[] list = new ArrayList<Integer>[6];

//init
for(int i=0;i<list.length;i++){
    list[i] = new ArrayList<Integer>();
}

//fill
while(sc.hasNextInt()){
    int number = sc.nextInt();
    if(sc.hasNextInt()){
        int index_to_add = sc.nextInt();
        list[index_to_add].add(number);
    }else{
        break;
    }
}