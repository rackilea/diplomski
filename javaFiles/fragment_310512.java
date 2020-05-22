public class TestAdapter extends BaseAdapter {
    Context mContext;

    public TestAdapter (Context context, Data someData) {
        this.mContext = context;

        // Set up the data for your listView however
    }
    @Override
    public int getCount() {
        return howManyRows;
    }

    @Override
    public Object getItem(int position) {
        return objectAtPosition;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    } // Unnecessary, unless using databases

    // The listener for the textViews, feel free to use different listeners
    View.OnClickListener TextViewListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // Get the view as a TextView, as this will only be used
            // with TextViews, so the only view to be passed
            // will be Textviews
            TextView textView = (TextView) v;

            // Do whatever with that text, or however you want to use the view
            String text = textView.getText().toString();
            someFunction(text);
        }
    };

    // Using the efficient pattern for recycling the views rather than using
    // findViewById repeatedly
    public static class ViewHolder{
        public TextView textView1;
        public TextView textView2;
        public TextView textView3;
        public TextView textView4;

        // And any other view that's part of the row view that you need
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = null;
        ViewHolder holder;

        if(convertView == null) {
            // Then gotta set up this row for the first time
            LayoutInflater inflater =
                    (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.row_layout.xml, parent, false);

            // Create a ViewHolder to save all the different parts of the row
            holder = new ViewHolder();
            holder.textView1 = (TextView) row.findViewById(R.id.textView1);
            holder.textView2 = (TextView) row.findViewById(R.id.textView2);
            holder.textView3 = (TextView) row.findViewById(R.id.textView3);
            holder.textView4 = (TextView) row.findViewById(R.id.textView4);

            // Make the row reuse the ViewHolder
            row.setTag(holder);
        }
        else { // Otherwise, use the recycled view
            row = convertView;
            holder = (ViewHolder) row.getTag();
        }

        // Set the current row's Textview onClickListeners
            // Note: You MAY be able to only set these once- feel free to set that
        holder.textView1.setOnClickListener(TextViewListener);
        holder.textView2.setOnClickListener(TextViewListener);
        holder.textView3.setOnClickListener(TextViewListener);
        holder.textView4.setOnClickListener(TextViewListener);

        // Set up the rest of the views however you need
            /*.....
              ......
             */

        return row;
    }
}