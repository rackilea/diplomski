class PersonMOdelProvider
{

private static List<Person> lst ;
private static PersonMOdelProvider content;
private PersonMOdelProvider()
{
  // Get data from data base layer.
  lst = new ArrayList<Person>();
  //load the list from database
}

public static PersonModelProvider getInstance()
{
 if (content!=null) return content;
content = new PersonMOdelProvider();
return content;
}

.
.
.
set ... get methods for binding db with model. 

}