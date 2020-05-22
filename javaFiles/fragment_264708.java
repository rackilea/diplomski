import java.util.ArrayList;
import java.util.List;

class Person
{
    void sayHello()
    {
        System.out.println("Hello from "+this);
    }
    void sayGoodbye()
    {
        System.out.println("Goodbye from "+this);
    }

}

// This interface already exists as java.util.function.Consumer in Java 8
interface Consumer<T> 
{
    void accept(T t);
}

public class ForEachTest
{
    public static void main(String[] args)
    {
        List<Person> persons = new ArrayList<Person>();
        for (int i=0; i<5; i++)
        {
            persons.add(new Person());
        }

        runJava8(persons);
        runJava7(persons);
    }

    private static void runJava8(List<Person> persons)
    {
        persons.stream().forEach(Person::sayHello);
        persons.stream().forEach(Person::sayGoodbye);
    }

    private static void runJava7(List<Person> persons)
    {
        runMethodJava7(persons, new Consumer<Person>()
        {
            @Override
            public void accept(Person person)
            {
                person.sayHello();
            }
        });
        runMethodJava7(persons, new Consumer<Person>()
        {
            @Override
            public void accept(Person person)
            {
                person.sayGoodbye();
            }
        });
    }


    public static void runMethodJava7(
        List<Person> persons, Consumer<? super Person> consumer)
    {
        for(Person person : persons)
        {
            consumer.accept(person);
        }
    }    
}