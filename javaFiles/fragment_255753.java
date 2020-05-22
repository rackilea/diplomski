public class MyFilter<A extends MyAdapterInterface,T> extends Filter {
        private final A adapter;
        private final Predicate<T> comparator; // Java 8 class - can easily be created by hand if you are using pre Java 8
        // see https://docs.oracle.com/javase/8/docs/api/java/util/function/Predicate.html

        private final List<T> originalList;
        private final List<T> filteredList;

        private MyFilter(A adapter, List<T> originalList, Predicate<T> predicate) {
            super();
            this.adapter = adapter;
            this.comparator = comparator;
            this.originalList = new LinkedList<>(originalList);
            this.filteredList = new ArrayList<>();
        }

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            filteredList.clear();
            final FilterResults results = new FilterResults();

            if (constraint.length() == 0) {
                filteredList.addAll(originalList);
            } else {
                final String filterPattern = constraint.toString().toLowerCase().trim();

                for (final T animal : originalList) {
                    if (predicate.test(animal)) {
                        filteredList.add(animal);
                    }
                }
            }
            results.values = filteredList;
            results.count = filteredList.size();
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            adapter.clearResults();   // method to be added to MyAdapterInterface
            adapter.addResults(results.values);  // method to be added to MyAdapterInterface
            adapter.notifyDataSetChanged();
        }
    }