public class Result{
   private int status = 0;
   private int num_backpack_slots = 0;
   private List<Item> items = null; 
}


public class Item{
   private int id = 0;
   private in toriginal_id = 0;
   private int defindex = 0;
   private int level = 0;
   private int quality = 0;
   private int inventory = 0;
   private int quantity = 0;
   private int origin = 0;
   private boolean flag_cannot_trade = true;
   private List<Equipped> equipped = null;
   private List<Attributes> attributes = null;
   private boolean flag_cannot_trade = false;
}

public class Equipped{
   //private int class = 0; // here json has 'class' field , you cant use this name, use SerializedName
    @SerializedName("class") private  int myclass = 0;
   private int slot = 0
}

public class Attributes{
   private int defindex = 0; 
   private int value = 0;
   private doublefloat_value= 0;
}