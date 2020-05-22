public class Test {

private String name;

public String getName() {
    return name;
}

public String getName2() {
    return this.name;
}

public void setName(String name) {
    //here I am asigning method parameter value to class level variable
    this.name = name;
}

public void setName2(String name) {
    //here  Iam not using this keyword 
    //Here There is no use of assign name = name 
    name = name;
}

public static void main(String[] args) {

    Test test = new Test();

    test.setName("test 123");

    System.out.println(test.getName());
    System.out.println(test.getName2());

    test.setName2("test 456");

    System.out.println(test.getName());
    System.out.println(test.getName2());

    test.setName("test 789");

    System.out.println(test.getName());
    System.out.println(test.getName2());
}