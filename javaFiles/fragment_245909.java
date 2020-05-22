class person {

    String name;
    int age;

    public person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //This class calls method talk.

    public void talk(){
        System.out.println("hello is:" +name);
        System.out.println("my age is :" +age);
    }

    public static void main(String[] args) {
        person myperson = new person("foobar", 21);
        myperson.talk();
    }

}