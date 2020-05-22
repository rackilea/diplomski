for (Iterator<AClass> it = list1.iterator(); it.hasNext(); ) {
    AClass c = it.next();
    if (set.contains(c.getNum())) {
        it.remove();
    }
}