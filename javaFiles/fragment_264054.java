public static void main(String[] args) {
    ItemLinkedList list = new ItemLinkedList();
    for (int i = 1; i <= 10; i++) {
        list.addBack(new ItemInfo("name-"+i, "rfd"+i, i, String.valueOf(i)));

    }
    while (list.size() > 0){
        System.out.println(list.removeFront().getName());
    }
}