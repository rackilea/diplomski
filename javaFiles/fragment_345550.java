class Dish 
{ 
      Description description = new Description ();

      void addDescription(Locale locale, String text)
      {
          description.addText(locale,text);
      }

      String getDescription(Locale locale) 
      {
          return description.getText(locale);
      }
 }

class Description 
{
    Map<Locale,String> descriptions = new HashMap<>();

    public void addText(Locale locale,String text) 
    {
        descriptions.put(locale,text);
    }

    public void getText(Locale locale) 
    {
        return descriptions.get(locale);
    }
}