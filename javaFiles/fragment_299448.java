public class Storage
{
     List<Record> records;
     public Storage()
     {
         this.records = new ArrayList<Record();
     }

     public void addRecord(int number, int count, Object code)
     {
          records.add(new Record(number, count, code));
     }
}