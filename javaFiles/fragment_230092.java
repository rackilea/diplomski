public abstract class BaseClass 
{      
  public Object executeTrans(Template template) 
  {
    tx.begin();            
    template.doTransaction();
    tx.commit();    
  }
}

public interface Template
{
  public void doTransaction();
}

public childClass extends BaseClass
{
  public List<String> getInfoFromDB()
  {
    executeTrans(
      new Template()
      {
        public void doTransaction() 
        {
          ...do get info from DB here.
        }
      }
    );
  }

  public void saveToDB()
  {
    executeTrans(
      new Template()
      {
        public void doTransaction() 
        {
          ...do save to DB here.
        }
      }
    );
  }
}