public class App 
{
    public static void main( String[] args )
    {
        String json = "{\"data\": [{\"alias\": \"be\",\"label\": \"vitryska\"},{\"alias\": \"vi\",\"label\": \"vietnamesiska\"},{\"alias\": \"hu\",\"label\": \"ungerska\"},{\"alias\": \"uk\",\"label\": \"ukrainska\"}]}";
        Type type = new TypeToken<Response<Language>>(){}.getType();
        Response<Language> resp = new Gson().fromJson(json, type);

        Language l = resp.getData().get(0);
        System.out.println(l.alias);

    }
}

class Response<T> {

   private List<T> data = null;

   public List<T> getData() { return this.data; }   

}

class Language {
   public String alias;
   public String label;
}