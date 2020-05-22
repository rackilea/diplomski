for(ListIterator<String> it = list.listIterator(); it.hasNext();){
    String value = it.next();

    if(value.equals("4")) {
        it.remove();
        it.add("6");
    }

    System.out.println("List Value:"+value);
}