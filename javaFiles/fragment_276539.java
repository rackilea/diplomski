public int compare(ClassA o1, ClassA o2) {
    if (o1.getId() > o2.getId())
        return 1;
    else if(o2.getId() > o1.getId())
        return -1;
    // 0  indicates equality.
    else return 0;
}