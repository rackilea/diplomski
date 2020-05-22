public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }
    public void getAge() {
        return age;
    }
    public void setAge(int newAge) {
        this.age = newAge;
    }

    @Override
    public String toString() {
        return name + ":" + age;
    }
}

// a main somewhere else
public static void main(String[] args) {
    List<String> firstList = new ArrayList<String>();
    List<String> secondList = new ArrayList<String>();

    Person tom = new Person("Tom", 20);

    firstList.add(tom);
    secondList.add(tom);

    System.out.println(firstList.get(0));  //output: Tom:20
    System.out.println(secondList.get(0)); //output: Tom:20

    //we modify the Person object in firstList
    firstList.get(0).setAge(33);

    System.out.println(firstList.get(0));  //output: Tom:33
    System.out.println(secondList.get(0)); //output: Tom:33

    //we modify the Person object 'tom'
    tom.setAge(99);

    System.out.println(firstList.get(0));  //output: Tom:99
    System.out.println(secondList.get(0)); //output: Tom:99

    //we now change the reference value of the Person object 'tom'
    tom = new Person("Sam", 44);

    System.out.println(firstList.get(0));  //output: Tom:99
    System.out.println(secondList.get(0)); //output: Tom:99

    //how about this
    secondList.set(0, new Person("Mat", 50);

    System.out.println(firstList.get(0));  //output: Tom:99
    System.out.println(secondList.get(0)); //output: Mat:50
}