public class MyAction extends ActionSupport{

  private List<String> countryList;
  // getter and setter for countryList

  public String execute() throws Exception{
   countryList=new ArrayList<String>();
   // Add values to list
   return SUCCESS;
 }
}