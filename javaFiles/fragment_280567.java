public interface SortX {
    public void startClick(A a, B b, C c);
}

public enum SortAEnum implements SortX<A, B, C> {
    SortA {
         public void startClick(A a, B b, C c) {
              newOne(a, b, c);
         }
    }, SortB {
         public void startClick(A a, B b, C c) {
              otherfunction(a);
         }
    }, SortB {
         public void startClick(A a, B b, C c) {
              someotherfunction(c, a);
         }
    }
}

public static void startClick(A a, B b, List<C extends OnClick> lstC, SortX sort){
   for (int i=0; i<lstC.size(); i++){
      sort.startClick(a, b, lstC.get(i));
   }
}