for(Items i : list) {
    boolean unknown = true;
    for(String name: cat1) {
        if(i.name.equalsIgnoreCase(name)) {
            lista1.add(i);
            unknown = false;
            break;
        }
    }
    if(unknown) {
        listUnknown.add(i);
    }
}