@DatabaseTable
public class RowItem
{
   @DatabaseField(generatedId = true)
   private int id;

   @DatabaseField
   private Bitmap photo;

   @DatabaseField
   private String photoURL;

   @DatabaseField
   private int online_status;

   @DatabaseField
   private String name;

   @DatabaseField
   private String last_seen;

   @DatabaseField
   private int delete;

   //Getters and Setters ...
}