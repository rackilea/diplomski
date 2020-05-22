public class AdapterDemoGrid extends BaseAdapter {

        private final Context context;

        private LayoutInflater mLayoutInflater;


        public AdapterDemoGrid(Context context) {

            mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            this.context = context;


        }


        @Override
        public void notifyDataSetChanged() {
            super.notifyDataSetChanged();
            //lastPosition = -1;
        }

        @Override
        public int getCount() {
            return 20;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View view, ViewGroup viewGroup) {
            ViewHolder holder = null;

            if (view == null) {

                //The view is not a recycled one: we have to inflate

                view = mLayoutInflater.inflate(R.layout.item_block.xml, viewGroup, false);

                holder = new ViewHolder();


                view.setTag(holder);

            } else {

                holder = (ViewHolder) view.getTag();
            }

            return view;
        }


        class ViewHolder {

            /// Item Block views goes here...

        }
    }