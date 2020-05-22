public class Holder<T> extends Vector<T>{

           public addTo(T item){
               super.add(item);
           }

           public takeFrom(T item){
                super.remove(item);
           }
     }


     public class Refrigerator extends Holder<FoodItem>{
     }

     public class Wallet extends Holder<Money>{
     }