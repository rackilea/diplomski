interface MyAction {
    void setField(A obj, B obj2);
}
...
Map<Integer,MyAction> actionByNumber = new HashMap<Integer,MyAction>();
actionByNumber.put(1, new MyAction() {
    void setField(A obj, B obj2) {
        obj.setField1(obj2.getOption1());
    }
});
actionByNumber.put(2, new MyAction() {
    void setField(A obj, B obj2) {
        obj.setField1(obj2.getOption2());
    }
});
...
A obj = ...
B obj2 = ...
for (int i = 0 ; i != 20 ; i++) {
    MyAction action = actionByNumber.get(i);
    if (action != null) {
       action.setField(obj, obj2);
    }
}