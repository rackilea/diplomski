class ShoppingCart{
  private ArrayList<Item2> items;

  public ShoppingCart2(){
    items = new ArrayList<Item2>();
  }

  public void addItem(Item2 item){
    items.add(item);
  }

  public void addItems(ArrayList<Items> items){
    this.items.addAll(items)
  }

  public double getTotal(){
    double total = 0L;
    for(Item2 item : items){      
      total += item.calculateUnitTotal();
    }
    return total;
  }

  public String toString(){
     StringBuffer sb = new StringBuffer();
     for (Item2 item: items){
       // Print each item here
       sb.append(item.toString());
       sb.append("----------------\n");
     }
     sb.append("*************");
     sb.append("Total Price: ");
     sb.append(getTotal());
     return sb.toString();     
  }
}