//Without overloading you'll have to set the properties after instantiating the class
public MyClass() {
    this.PropertyOne = "1";
    this.PropertyTwo = 2;
}

//usage:
MyClass instance = new MyClass(); 
//now theproperties are already set to "1" and 2, wheter you like it or not
//here you change the values
instance.PropertyOne = "...";
instance.PropertyTwo = 0;

//With constructor overloading you have this
public MyClass() {
    this("One", 2);
}

public MyClass(string propOne, int propTwo) {
    this.PropertyOne = propOne;
    this.PropertyTwo = propTwo;
}

//usage:
MyClass instance = new MyClass("MyValue", 1000);
//if you call MyClass() the default values STILL will be set :)