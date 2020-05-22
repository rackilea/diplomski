// Thread 1
GlobalData d = GlobalData.getInstance(); //S1
d.setData("one");

// Thread 2
GlobalData d = GlobalData.getInstance(); //S2
d.setData("two");

// Thread 1
String value = d.getData();