class NoteListAdapter extends ArrayAdapter<Note> implements Filterable
 {
List<Note> objects;
private List<Note> mStringFilterList;
 Filter filter;
private static final int WRAP_CONTENT_LENGTH = 5;
public NoteListAdapter(Context context, int resource, List<Note> objects) {
    super(context, resource, objects);
    this.objects = objects;
  this.mStringFilterList = objects;

}

 @Override
  public int getCount() {
  return mStringFilterList.size();  // change this line
  }

 @Nullable
 @Override
 public Note getItem(int position) {
   return mStringFilterList.get(position);   // change this line
 }

@Override
public long getItemId(int position) {
   return position;
 }


@Override
public Filter getFilter() {
    filter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            ArrayList<Note> tempList= new ArrayList<>();
            FilterResults results = new FilterResults();
            if (constraint != null && constraint.length() > 0 && objects != null) {
                for(Note singleNote : objects) {
                    if( singleNote.getTitle().contains(constraint))
                        tempList.add(singleNote);
                }
                results.values = tempList;
                results.count = tempList.size();
            }

             // add else block. 
            else
            {
             results.values = objects;
                results.count = objects.size(); 
            }

            return results;
        }
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            mStringFilterList = (ArrayList<Note>) results.values;  // change this line
            notifyDataSetChanged();

        }
    };
    return filter;

    }


}