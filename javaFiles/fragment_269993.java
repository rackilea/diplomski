public class MyActivity extends Activity implements OnItemClickListener {
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        lv = (ListView) findViewById(R.id.lvList);
        MyAdapter adapter = new MyAdapter(this);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        MyView holder = (MyView) view.getTag(); // This will get the tag of the item click - that is set up below
    }

    //Create a holder for the image that will be in an ImageView
    class SingleRowData {
        int img;

        SingleRowData(int img) {
            this.img = img;
        }
    }

    //A reference to the ImageView that needs to be copied
    private class MyView {
        ImageView ivImg;

        MyView(View v) {
            ivImg = (ImageView) v.findViewById(R.id.ivHomePageRow);
        }
    }

    class MyAdapter extends BaseAdapter{
        ArrayList<SingleHPSRow> list;
        Context context;

        public MyAdapter(Context context) {
            this.context = context;
            list = new ArrayList<SingleRowData>();
            ...
            int[] imgId = ...; // let's say you are getting all the images from your resources .. you will have to set this up, I'm guessing you know how to.
            for(int item = 0; item < imgUrl.length; i++) {
                list.add(imgId[item]);
            }
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            view row = convertView; //This will try to see if the row has already been loaded b4
            MyView holder = null; initialize our custome View for the row
            if(row == null) { // new row
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE); //Get the LayoutInflater
                row = inflater.inflate(R.layout.singleRow, parent, false); //Reference to the row layout
                holder = new MyView(row);
                row.setTag(holder); // Give the row a tag - the holder that contains the item
            } else { // old row
                holder = (MyView) row.getTag(); //Get the tag that was assigned
            }
            SingleRowData item = list.get(position); //Get the item at the current position
            int image = item.img; //Get the imgId assigned to the current item
            holder.ivImg.setImageResource(image); //Load image for the current position
            return row; // Return the current row
        }
    }
}