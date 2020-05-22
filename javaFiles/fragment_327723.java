public class AbstractGroupedAdapter<T,Y> extends ArrayAdapter<List<Y>> {


  protected Map<T, List<Y>> groupedItems;

   protected T getHeaderAtPosition(int position) {
      // return the correct map key
   }

   protected Y getItemAtPosition(int position) {
      // return the correct map value
   }

   @Override
   public int getCount() {
      return groupedItems.size() + groupedItems.values().size();
   }
}