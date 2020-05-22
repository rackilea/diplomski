public class Demo {

    public static void main(String args[]) throws CloneNotSupportedException{

    Person p1=new Person();
    p1.setAge(30);


    Person p2 = (Person) p1.clone();
    p1.setAge(40);
    System.out.println(p2.getAge());//30

    }
    }

    class Person implements Cloneable{

    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        // TODO Auto-generated method stub
        return (Person)super.clone();  
    }
}