@Override
public int compare(CustomClass o1, CustomClass o2) {
    int priority1,priority2;
    priority1 = o1==null ? Integer.MAX_VALUE : o1.getPriority();
    priority2 = o2==null ? Integer.MAX_VALUE : o2.getPriority();
    return priority1==priority2 ? 0 : (priority1<priority2 ? -1 : 1);
}