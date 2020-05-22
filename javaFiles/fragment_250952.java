private boolean visible = false;
private List<String> opList;

public Test() {

    opList = optionList();
}


public List<String> getOpList() {
    return opList;
}
public void setOpList(List<String> opList) {
    this.opList = opList;
}
public boolean isVisible() {
    return visible;
}
public void setVisible(boolean visible) {
    this.visible = visible;
}

public List<String> optionList(){

    List<String> list = new ArrayList<String>();
    list.add("Select Item");
    list.add("test1");
    list.add("test");
    return list;
}
public void valuChangeHandler(ValueChangeEvent changeEvent){

    if(changeEvent.getNewValue().toString().trim().equalsIgnoreCase("test1"))
        setVisible(true);
}