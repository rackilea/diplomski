/*in Item */
Item add(String value){
   Item item = new Item(this.value);
   if(value.compareTo(this.value)<0){
      item.left = this.left;
      item.right = this.right.add(value);
   }else{
      item.left = this.left.add(value);
      item.right = this.right;
   }
   return item;
}