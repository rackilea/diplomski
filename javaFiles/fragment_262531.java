String s = "hello";
Object o = s;
s = (String) o; //works

//but

String s = "hello";
Object o = s;
o = new Object;
s = (String) o; //gives you a ClassCastException because an Object
                //cannot be referred by a string