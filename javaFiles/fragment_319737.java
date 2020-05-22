String[] myStringArray = {"Object1","Object2","Object3"};
String[] myNewStringArray = new String[myStringArray.length + 1];
System.arraycopy(myStringArray, 0, myNewStringArray, 0, myStringArray.length);
myNewStringArray[myNewStringArray.length - 1] = extras.getString("key");

txtV1.setText(myNewStringArray[new Random().nextInt(newArray.length)]);