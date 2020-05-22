public class Item {
     private String name;
     private String price;

     public Item(String name, String price) {
        this.name=name;
        this.price=price;
     }

     public String getName() {
        return name;
     }

     public String getPrice() {
        return price;
     }
}

/**
 *
 * Get item at position {@code position} or {@code null} if not found.
 *
 */
private Item getHighestItem(int position, WebDriver driver) {
   Item item=null;

   try {
      int index = position-1;
      String name = driver.findElement(By.xPath("//*[@id='result_" + index + "_name']")).getText();
      String price = driver.findElement(By.xPath("//*[@id='result_" + index + "']/div[1]/span[1]/span")).getText();

      item = new Item(name, price);
   } catch(NoSuchElementException nse) {
       // handle exception here...
   }

   return item;
}