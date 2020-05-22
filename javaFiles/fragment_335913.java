f(int index){
    List<Action> list = actionList.get(index);
    if (list == null) {
        list = new ArrayList<Action>();
        actionList.set(index, list);
    }
    // Note: no need to use index at all here... potentially
    list.add(new Action());
}