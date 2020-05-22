public class MainActivity extends Activity {

ListView mainList;
String[] listContent = {
        "Line 1", "Line 2", "Line 3", "Line 4"
};

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    mainList = (ListView)findViewById(R.id.main_listView);
    MyColoringAdapter adapter = new MyColoringAdapter(this,listContent);
    mainList.setAdapter(adapter);

    mainList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
            //When clicked, go to specific activity
            Toast.makeText(getApplicationContext(),"Clicked on list item "+position,Toast.LENGTH_SHORT).show();
            switch (position) {
                case 0:
                    //code specific to first list item
                    break;
                case 1:
                    //code specific to second list item
                    break;
            }
        }
    });
}

private class MyColoringAdapter extends ArrayAdapter<String> {
    private final Context context;
    private final String[] values;

    public MyColoringAdapter(Context context, String[] values) {
        super(context, R.layout.list_item, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.list_item, parent, false);
        TextView textView = (TextView) rowView.findViewById(R.id.list_textview);
        // Set text
        textView.setText(values[position]);
        // Set color depending on position
        int textColorId = R.color.black; // Default color
        switch (position%2) {
            case 0:
                // Even places
                textColorId = R.color.red; break;
            case 1:
                // Odd places
                textColorId = R.color.green; break;
        }
        textView.setTextColor(getResources().getColor(textColorId));
        return rowView;
    }
}
}