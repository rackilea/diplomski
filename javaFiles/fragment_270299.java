public class HomeData implements Cloneable{

  public Object clone(){
      HomeData copy= new HomeData();
      copy.setValue(this.getValue());
      copy.setSomething(this.getSomething());

      //... and so on
      return copy;
   }

   ....
 }