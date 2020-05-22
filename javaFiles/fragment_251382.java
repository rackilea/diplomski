if(items[i] instanceof Game) {
   Game g = (Game)items[i];
   g.SomeGameSpecificFunc();
} else if(items[i] instanceof Book) {
   //...
}