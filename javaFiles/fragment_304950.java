// here are several reference variables
// all without assigned objects, and thus
// all holding "null" values:
JButton Beans;
String String1;
JPanel things;


public Actions()  {
    //..... 

    // here you assign the String object, "Beans" to the String1 variable
    String1 = "Beans";

    // .....

    // here you create a JButton and pass in String1's current object, "Beans"
    // into the constructor (note the "" + is NOT needed for Strings, only for numberrs)
    Beans = new JButton("" + String1);

    //.....
}

public void actionPerformed(ActionEvent e)  {
    // here you change the object that String1 refers to
    String1 = "Surprise!";

    // but this has no effect on the original String object, "Beans" displayed in the
    // JButton, but rather all it does is change the state of String1. 
    // To change the state of the JButton, you must explicitly do this 
    // by calling setText on it

    //....