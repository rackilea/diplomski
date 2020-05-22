public class ListWithout extends AbstractList<Integer> {
   private final List<Integer> parent;
   private final int elementToRemove;

   public ListWithout(List<Integer> parent, int elementToRemove) {
       this.parent = parent;
       this.elementToRemove = elementToRemove;
   }

   @Override
   public int size() {
      return parent.size() - 1;
   }

   @Override
   public Integer get(int index) {
      if(index >= elementToRemove) {
          index++;
      }
      return parent.get(index);
   }