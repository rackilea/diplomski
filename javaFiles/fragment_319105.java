public List<? extends Object> getList(Object e) {
    List<? extends Object> list = new ArrayList<? extends Object>();
    if(e instanceof ClassA) {
        List<ClassA> listA = new ArrayList<ClassA>();
        // Populate list somehow
        list = listA;
    } else if (e instanceof ClassB) {
        List<ClassB> listB = new ArrayList<ClassB>();
        // Populate list somehow
        list = listB;
    }
    return list;
}