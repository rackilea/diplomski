public class Program{

    public static class ObjectMap{
     private String programme_title, working_title;

      public String getprogramme_title() { return programme_title; }
     public String getworking_title() { return working_title; }

     public void setprogramme_title(String s) { programme_title= s; }
     public void setworking_title(String s) { working_title= s; }
   }

   private ObjectMap objMap;

   private String name;

   public ObjectMap getobjectMap () { return objMap; }
   public void setObjectMap  (ObjectMap n) { objMap= n; }

   private Long id;
   public Long getId() {return id;}
   public void setId(Long id) {this.id = id;}

   private String name;
   public String getName() {return name;}
   public void setName(String name) {this.name = name;}
  }