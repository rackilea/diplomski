public class MainActivity extends Activity {

    ListView lv;
    String[] title;
    CategoryImageAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv=(ListView) findViewById(R.id.listView1);

        title=getResources().getStringArray(R.array.titles);

        adapter=new CategoryImageAdapter(MainActivity.this, title);
        lv.setAdapter(adapter);

    }

    public class CategoryImageAdapter extends BaseAdapter implements OnClickListener {

        private Activity activity;
        private String[] data;
        private LayoutInflater inflater = null;

        public CategoryImageAdapter(Activity a, String[] d) {
            activity = a;
            data = d;
            inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        }


        @Override
        public int getCount() {
            return data.length;
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public void onClick(View v) {

        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View vi=convertView;
            ViewHolder holder;
            if(convertView == null){
                vi = inflater.inflate(R.layout.row_lv, null);
                holder = new ViewHolder();
                holder.text = (TextView)vi.findViewById(R.id.textView1);
                vi.setTag(holder);
            }
            else
                holder=(ViewHolder)vi.getTag();

            holder.text.setText("Title " + data[position]);

            return vi;
        }
    }
        public class ViewHolder {
            public TextView text;

        }

}