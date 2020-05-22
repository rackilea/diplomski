class CustomAdapter extends ArrayAdapter implements Filterable {

private List<Data> dataList;
private List<Data> mSdataFilterList;
        public CustomAdapter(Context context, int resource) {
            super(context, resource);
           //initialize both lists with unfiltered data
        }

        @Override
        public Filter getFilter() {
            // return a filter that filters data based on a constraint

            return new Filter() {
                @Override
                protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults results = new FilterResults();
                for (int i = 0; i < mSdataFilterList.size(); i++) {
                if ((mSdataFilterList.get(i).getData().toUpperCase())
                        .contains("footbal")||(mSdataFilterList.get(i).getData().toUpperCase())
                        .contains("soccer")) {

                    Data data= new Data(
                    mSdataFilterList.add(data);
                }
            }
            results.count = mSdataFilterList.size();
            results.values = mSdataFilterList;
                    return results;
                }

                @Override
                protected void publishResults(CharSequence constraint, FilterResults results) {
                  dataList= (ArrayList<Data>) results.values;
                  notifyDataSetChanged();
                }
            };
        }