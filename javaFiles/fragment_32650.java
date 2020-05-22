for(int i = 0; i < v.size(); i++) {
    DemoData demoData = new DemoData();
    demoData.fieldNames = new ArrayList<>(); // line# 1
    demoData.values = new ArrayList<>(); //line# 2
    demoData.autoId = k.get(i).toString();
    HashMap m = v.get(i);
    demoData.fieldNames.addAll(m.keySet());
    demoData.values.addAll(m.values());
}