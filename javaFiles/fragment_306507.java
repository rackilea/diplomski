while (comp.size() > 0) {
    String e = comp.get(0);
    int c = Collections.frequency(comp, e);
    if (c > count) {
        count = c;
        ele = e;
    }
    comp.removeAll(Collections.singleton(e));
}
System.out.print(ele);