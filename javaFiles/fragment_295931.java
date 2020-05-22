public class MyAdapter extends BaseAdapter{
        List thisList;
        Context thiscontext;
        LayoutInflater inflater;
        public MyAdapter(Context context,List list) {
            thiscontext = context;
            thisList = list;
            inflater= (LayoutInflater) context.getSystemService (Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return  thisList.size ();
        }

        @Override
        public Object getItem(int i) {
            return thisList.get (i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }
        // new method

        private void updateView(Boolean value, int index){
        View v = thisList.getChildAt(index - 
        thisList.getFirstVisiblePosition());

        if(v == null)
        return;

        TextView boxView = (TextView) v.findViewById (R.id.boxView);
        if (value && value != null) {
        boxView.setText("Present");
        } else if (!value && value !=null) {
        boxView.setText("Absent");
        }