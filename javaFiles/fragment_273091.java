private int getPriority(CustomClass obj) {
    if(obj!=null&&PRIORITIES.containsKey(obj.getType())) {
        priority1 = PRIORITIES.get(obj.getType());
    } else {
        priority1 = Integer.MAX_VALUE;
    }
}

@Override
public int compare(CustomClass o1, CustomClass o2) {
    int priority1,priority2;
    priority1 = getPriority(o1);
    priority2 = getPriority(o2);
    return priority1==priority2 ? 0 : (priority1<priority2 ? -1 : 1);
}