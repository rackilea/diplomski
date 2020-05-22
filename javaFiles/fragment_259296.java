public abstract class Person {   
    protected final String name;
    public Person(String name) { 
        this.name = name;
    }
}

public class Male extends Person {
    public Male(String name) { 
        super(name);
    }
}

public class Female extends Person {
    public Female(String name) { 
        super(name);
    }
}

public class PersonFactory
{
     public static Person makePerson(String gender, String name) 
     {
         if(gender.equals("male"))                       
         { 
             Male man=new Male(name);
             return man;
         }
         else
         {
             Female woman=new Female(name);
             return woman;
         }
     }
}

public class Test 
{
    public static void main(String[] args)
    {
       Person y= PersonFactory.makePerson("male", "bob"));
       Person z= new PersonFactory.makePerson("female", "janet"));
    }
}