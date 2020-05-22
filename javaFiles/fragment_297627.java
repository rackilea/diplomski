List<Integer> list = new ArrayList<>();
int array[] = {1,1,2,4,5,3,1,5};
int max = array[0];
list.add(0);
for(int i=1;i<array.length;i++){
    if(max<array[i]){
        max = array[i];
        list.clear();
        list.add(i);
    }else if(max==array[i])
        list.add(i);
}
System.out.println(list);