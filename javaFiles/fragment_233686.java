@Service
public class AService    
{
     private List<String> list;

     private ExecutorService executorService;

     public void addAndInsert(String query)  
     {
           synchronized(list)
           {          
                list.add(query);
                if(list.size() >= 1000)
                {
                    executorService.execute(writeIntoDataBase(new LinkedList<String>(list)));
                    list.clear();
                }
            }
      }

      private Runnable writeIntoDataBase(List<String> list)
      {
          //TODO - Create your Runnable to write data to the db.

      }
}