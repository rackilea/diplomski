//Artpiece.java
interface Artpiece{
    public String name();
    public Bundling bundling();
    public float price();

}

//BubbleWrap.java
public class BubbleWrap implements Bundling{
    public String bundle() {
        return "BubbleWrap";
    }
}

//Bundling.java
interface Bundling{
    public String bundle();
}

//Cushioning.java
public class Cushioning implements Bundling{
    //Override
    public String bundle() {
        return "Cushioning";
    }
}

//FGItem.java
abstract class FGItem implements Artpiece{
    public Bundling bundling() {
        Bundling b = new BubbleWrap();
        return b;
    }
    public abstract float price();

}

//GlassWaare.java
public class GlassWare extends FGItem{

    //Override
    public String name() {

        return "GlassWare";
    }

    //Override
    public float price() {

        return 160;
    }

}

//Pottery.java
public class Pottery extends FGItem{

    //Override
    public String name() {

        return "Pottery";
    }

    //Override
    public float price() {

        return 25;
    }

}

//ArtItems.java
import java.util.ArrayList;
public class ArtItems implements Artpiece{

    float sum = 0;
    ArrayList<Artpiece> item = new ArrayList<Artpiece>();


    //Override
    public String name() {

        return name();
    }

    //Override
    public Bundling bundling() {

        return bundling();
    }

    //Override
    public float price() 
    {
        return price();
    }

    public float getCost()
    {
        for(int i=0; i<item.size(); i++)
        {
            Artpiece art = item.get(i);
            sum += art.price();
        }
        return sum;

    }

    public void addItem(Artpiece artpiece) 
    {

        item.add(artpiece);
    }

    public void showItems() 
    {
        for(int i=0; i<item.size(); i++)
        {
            Artpiece art = item.get(i);
            System.out.println("Item: " + art.name() + " Packaging " + art.bundling().bundle() + ", Price: " + art.price());
        }

    }



}

//Dispatcher.java

public class Dispatcher { 
      public ArtItems prepareFGitem(){ 
      ArtItems artitems = new ArtItems(); 
      artitems.addItem(new Pottery()); 
      artitems.addItem(new GlassWare());
          return artitems;
      }


}

//Salesorder.java  This is the driver class
 public class Salesorder { 
   public static void main(String[] args) { 
     Dispatcher dispatcher = new Dispatcher(); 
      ArtItems FGartitem = dispatcher.prepareFGitem(); 

      System.out.println("Fragile Items"); 
      FGartitem.showItems(); 
      System.out.println("Total Cost: " +FGartitem.getCost()); 


   } 
}