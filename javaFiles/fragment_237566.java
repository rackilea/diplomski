Iterator<String> it = list1.iterator();
int i=0;
while(it.hasNext()){
    String s = it.next();
    i++;
    if (i==2){
        it.remove();
        System.out.println("removed: "+ s);
    }
}