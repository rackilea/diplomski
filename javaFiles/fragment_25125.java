public class YourClass{
   private List<yourType> list; 

   public void parseKML(){ //your method in which you are parsing KML file.
      ...
      ...

      list = new ArrayList<your type>();
      // and now save all variable in this list rather then saving it to local ArrayList
    ...
   }

  public List<yourtype> getKMLList(){
     // to Minimize mutibility Effective java item 15  
     return list.clone();  
   }
}