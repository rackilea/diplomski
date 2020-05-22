class Clever {
   Map map;

   Map getMap(){
       if(map==null){
           map = deriveMap();        }
       return map;
   }
}