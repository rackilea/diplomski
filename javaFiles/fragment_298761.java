public class Person
{
    public Person(int age)
    {
        System.out.println("person with age " + age);
    }
    public void rest(int hours)
    {
        System.out.println("person rests " + hours);
    }
}

public class PersonStoryDerivedTest extends PersonStoryTest {
    public PersonStoryDerivedTest()
    {
        System.out.println("PersonStoryDerivedTest cnstr.");
    }
    private void thePersonRests(Integer hours) {
        person.rest(hours);
    }
    public void ff(String g){
        System.out.println("Alex");
    }

    public class InnerClass extends PersonStoryTest {
        public InnerClass() { System.out.println("InnerClass cnstr."); }
        public void aPerson(Integer age) {
            person = new Person(age);
        }

        public void foo(String g){
            System.out.println("David");
        }
    }
}

public class PersonStoryTest
{
    public PersonStoryTest()
    {
        System.out.println("PersonStoryTest cnstr.");
    }
    Person person;
}

import java.lang.reflect.*;
public class test {
public static void main(String[] args) throws Exception {
    PersonStoryDerivedTest a = new PersonStoryDerivedTest();
    Method[] g1 =  a.getClass().getDeclaredMethods();
    g1[1].invoke(a,"fff");   // print Alex (works well)

    PersonStoryDerivedTest.InnerClass ab = a.new InnerClass();
    Class<?>[] b = a.getClass().getDeclaredClasses(); 
    Method[] g =  b[0].getDeclaredMethods();
    g[1].invoke(ab,"fff"); // print David  (works well)
    Constructor<?>[] cs = b[0].getConstructors();
    Object o = cs[0].newInstance(a);
    g[1].invoke( o ,"fff");   // now works too... 
    }
}