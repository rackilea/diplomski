Collections.sort(itemsList, new Comparator<ShopItem>(){
                     public int compare(ShopItem i1, ShopItem i2){
                         if(i1 == null || i2 == null)
                              return 0; //do properly nullable handling
                         return i1.getItemName().compareTo(i2.getItemName());
                     }
                  });