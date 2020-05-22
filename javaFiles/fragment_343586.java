public class Person
{
   private String name;
   private Map<Object, Object> someInfo;

   public Person()
   {
   }

}

Person person = new Person();
person.name = "Charles";
person.someInfo = new HashMap<Object, Object>();
person.someInfo.put("key1","value1");