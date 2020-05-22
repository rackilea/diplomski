class MyAdapter extends RecyclerView.Adapter<MyViewHolder> implements Filterable {
      private mFilter = new NewFilter();
      private List<MyData> mItems;
      private List<MyData> mFiltered = new ArrayList<>();     // <--- use this collection in all required getItemsCount and onBindViewHolder methods

      public Filter getFilter {
            return mFilter;
      }

      public class NewFilter extends Filter {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                mFiltered .clear();
                final FilterResults results = new FilterResults();
                if(charSequence.length() == 0){
                    mFiltered .addAll(mItems);
                }else{
                    final String filterPattern =charSequence.toString().toLowerCase().trim();
                    for(MyData item: mItems) {
                        if(item.getMyProperty().toLowerCase().contains(filterPattern)){ // replace this condition with actual you need
                            mFilteredItems.add(item);
                        }
                    }
                }
                results.values = mFilteredItems;
                results.count = mFilteredItems.size();
                return results;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                this.mAdapter.notifyDataSetChanged();
            }
        }