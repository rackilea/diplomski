class Parent {

    public String parentField;

    public Parent(){
        parentField = "Hello";
    }
}

class Child extends Parent {

    public int childField = parentField.length();
}