class DeliveryItem  
   {  
        addItem(DeliveryItem item){...}  
   }  

class Luggage extends DeliveryItem  
{  
    //override addItem if need be
}    

class Freight
{  
     List<DeliveryItem> items = new ArrayList<DeliveryItem>();  

     List<DeliveryItem> getItems()  
     {  
        return this.items;  
      }

     void addItem(DeliverItem item)  
     {
         this.items.add(item);
     }  
}