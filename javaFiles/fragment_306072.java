public class DelimiterAdapter extends ArrayAdapter<String> implements Filterable { 
    private final static String [] options = { 
        "Apple","Mango","Peach","Banana","Orange","Grapes","Watermelon","Tomato" 
    }; 
    private final LayoutInflater mInflater; 
    private List<String> mSubStrings; 

    private String mMainString; 
    public String getMainString() { return mMainString; } 

    private AmazingFilter mFilter; 

    public DelimiterAdapter(Context context, int resource) { 
        super(context, -1); 
        mInflater = LayoutInflater.from(context); 
    } 

    @Override 
    public View getView(int position, View convertView, ViewGroup parent) { 
        final TextView tv; 
        if (convertView != null) { 
            tv = (TextView) convertView; 
        } else { 
            tv = (TextView) mInflater.inflate(android.R.layout.simple_dropdown_item_1line, parent, false); 
        } 
        tv.setText(getItem(position)); 
        return tv; 
    } 

    @Override 
    public int getCount() { 
        return mSubStrings.size(); 
    } 

    @Override 
    public String getItem(int position) { 
        return mSubStrings.get(position); 
    } 

    @Override 
    public long getItemId(int position) { 
        return position; 
    } 


    @Override 
    public Filter getFilter() { 
        if(mFilter == null) { 
            mFilter = new AmazingFilter(); 
        } 
        return mFilter; 
    } 

    private class AmazingFilter extends Filter { 

        private final static String DELIMITER = "+"; 

        @Override 
        protected FilterResults performFiltering(CharSequence constraint) { 
            final FilterResults filterResults = new FilterResults(); 
            String request; 
            mSubStrings = new ArrayList<String>(); 
            if(constraint != null) { 
                request = constraint.toString(); 

                //cuts the string with delimiter 
                if (request.contains(DELIMITER) && 
                        request.lastIndexOf(DELIMITER) != request.length() - 1) { 
                    final String[] splitted = request.split("\\" + DELIMITER); 
                    request = splitted[splitted.length - 1].trim(); 

                    //save string before delimiter 
                    int index = constraint.toString().lastIndexOf(request); 
                    mMainString = constraint.toString().substring(0, index); 
                } else { 
                    request = request.trim(); 
                    mMainString = ""; 
                } 


                //checks for substring of any word in the dictionary 
                for(String s : options) { 
                    if(s.contains(request)) { 
                        mSubStrings.add(s); 
                    } 
                } 
            } 
            filterResults.values = mSubStrings; 
            filterResults.count = mSubStrings.size(); 
            return filterResults; 
        } 

        @Override 
        protected void publishResults(CharSequence constraint, FilterResults results) { 
            clear(); 
            for (String request : (ArrayList<String>)results.values) { 
                add(request); 
            } 
            if (results.count > 0) { 
                notifyDataSetChanged(); 
            } else { 
                notifyDataSetInvalidated(); 
            } 
        } 
    } 
}