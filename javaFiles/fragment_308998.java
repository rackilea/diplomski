public class MyApplication extends Application
   {
     private static MyApplication instance;
     private FavouritesManager favouritesManager;

     public static getMyApplicationInstance ()
     {
        return instance;
     }

     public void onCreate ()
     {
         instance = this;
         favouritesManager = new FavouritesManager(this); // You may want it to have a Context...
     }
 }


   public class FavouritesManager
   {
     private Map<Integer,Favourites> favorites;

     public FavouritesManager ()
     {
         load();
     }

     public void add ( Favourite favourite )
     {
         favourites.put(favourite.id, favourite);
     }

     public boolean contains ( int favouriteId )
     {
       favourites.contaisKey(favouriteId);
     }

     private void load ()
     {
        favourites = new HashMap<>();
        // Maybe deserialize json from SharedPreferenecs?
     }

     public List<Favorite> getAll ()
     {
        // Return all Favourites, sorted by their SortOrder.
     }

     public Favorite create ( String name )
     {
        // Maybe a factory method that generates an unused id and returns a new Favourite instance?
     }
 }


 public Favourite
 {
     public final int id;
     public final Date createDate;
     public String name;
     public int sortOrder;

     public Favorite ( int id, String name, int sortOrder )
     {
         this.id = id;
         this.createDate = Date();
         this.name = name;
         this.sortOrder = sortOrder;
     }
 }


 public class MyActivity extend Activity
 {
      protected void onCreate ( Bundle savedInstanceState )
      {
           FavouritesManager favmanager = MyApplication.getMyApplicationInstance().getFavoritesManager();
      }

 {
}