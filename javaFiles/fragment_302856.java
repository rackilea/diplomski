public class Student
{
      private HashMap<String, String> values;

      public Student()
      {
          this.values = new HashMap<String, String>();
      }

      public void addValue(String name, String value)
      {
          values.put(name, value);
      }

      public String getValue(String name)
      {
          return values.get(name);
      }
}