public static <T> void permute(
    final List<List<T>> lists,
    final Consumer<List<T>> consumer
)
{
     final int[] index_pos = new int[lists.size()];

     final int last_index = lists.size() - 1;
     final List<T> permuted = new ArrayList<T>(lists.size());

     for (int i = 0; i < lists.size(); ++i) {
         permuted.add(null);
     } 

     while (index_pos[last_index] < lists.get(last_index).size()) {
         for (int i = 0; i < lists.size(); ++i) {
            permuted.set(i, lists.get(i).get(index_pos[i]));
         }  
         consumer.accept(permuted);

         for (int i = 0; i < lists.size(); ++i) {
             ++index_pos[i];
             if (index_pos[i] < lists.get(i).size()) {
                /* stop at first element without overflow */
                break;
             } else if (i < last_index) {
                index_pos[i] = 0;
             }  
         }
     }
}