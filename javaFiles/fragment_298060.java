String a = (String)e1.getValue();
String b = (String)e2.getValue();

int index1 = list.indexOf(a.substring(0, 1));
int index2 = list.indexOf(b.substring(0, 1));

int diff = Integer.compare(index1, index2);