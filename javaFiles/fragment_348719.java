ContentPanel cp ... //available as a reference (design time)

addForm(....) {
    FormPanel fp = new Formpanel();
    ......
    cp.add(fp);
    **cp.layout();**
}