public class MainActivity extends AppCompatActivity {

    private List<Pair> list;
    private ListAdapter listAdapter;
    private ListView myView;
    private int lastClickedPosition = 0;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(new Pair("Hello world " + i, false));
        }
        listAdapter = new ListAdapter();
        myView = (ListView) findViewById(R.id.myList);
        myView.setAdapter(listAdapter);
        myView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                list.get(lastClickedPosition).flag = false;
                list.get(position).flag = true;
                lastClickedPosition = position;
                listAdapter.notifyDataSetChanged();
            }
        });
    }

    public class ListAdapter extends BaseAdapter {
        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = getLayoutInflater().inflate(R.layout.listview_layout, null);
            TextView txt = (TextView) view.findViewById(R.id.textView);
            txt.setText(list.get(i).text);

            if (list.get(i).flag) {
                txt.setTextColor(Color.RED);
                txt.setTypeface(Typeface.MONOSPACE, Typeface.BOLD);
            } else {
                txt.setTextColor(Color.BLACK);
                txt.setTypeface(Typeface.MONOSPACE, Typeface.NORMAL);
            }

            return view;
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }
    }

    static class Pair {
        String text;
        boolean flag;

        Pair(String text, boolean flag){
            this.text = text;
            this.flag = flag;
        }
    }
}