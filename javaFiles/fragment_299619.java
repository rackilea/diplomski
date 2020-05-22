for (int i = 0; i < list.size(); i++) {
    int element = list.get(i);
    if(element == 1){
        System.out.println(element);
        list.add(3);

    }
    else if(element == 2){
        System.out.println(element);
        list.add(4);
    }
    else
        System.out.println(element);
}
System.out.println(list);