@Test
public void fromArrayToSet() {

    List<Integer> list = createList();
    HashSet<Integer> set = new HashSet<>();
    System.out.println("ListBefore = " + list);
    System.out.println("SetBefore = " + set);
    for(int i = 0; i < 10; i++) {
        arraylist((ArrayList) list, set );
    }
}

public void arraylist(List<Integer> list, HashSet set){
    int random = new Random().nextInt(list.size());
    arrayExist(list, list.get(random), set);
}

public void arrayExist(List<Integer> list ,int num, HashSet set){

    set.add(num);
    list.remove((Integer) num);

    System.out.println("ListAfter = " + list);
    System.out.println("SetAfter = " + set);
}

public List<Integer> createList() {

    List<Integer> list = new ArrayList<Integer>(10);
    for(int i = 0;i<10;i++){
        list.add(i);
    }
    return list;
}