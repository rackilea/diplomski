public class MainActivity extends AppCompatActivity {

    PopupWindow popupWindow;
    private ArrayList<DropDownItems> items = new ArrayList<DropDownItems>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        items.add(new DropDownItems("Settings", 0, false));
        items.add(new DropDownItems("Likes", 10, true));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);

        ImageButton item1 = (ImageButton) menu.findItem(R.id.more).getActionView().findViewById(R.id.dropDowmImageBtn);
        item1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopUpWindow(v);
            }
        });

        return true;
    }

    private void showPopUpWindow(View v) {

        DropDownAdapter adapter = new DropDownAdapter(v.getContext(), items);

        popupWindow = new PopupWindow(this);

        ListView listViewSort = new ListView(this);
        listViewSort.setDivider(null);
        listViewSort.setDividerHeight(0);
        listViewSort.setAdapter(adapter);

        popupWindow.setFocusable(true);
        popupWindow.setWidth(400);
        popupWindow.setHeight(WindowManager.LayoutParams.WRAP_CONTENT);
        popupWindow.setContentView(listViewSort);

        popupWindow.showAsDropDown(v, 0, 0);
    }

    public class DropDownAdapter extends BaseAdapter {

        Context context;
        ArrayList<DropDownItems> items;

        public DropDownAdapter(Context context, ArrayList<DropDownItems> items) {
            this.context = context;
            this.items = items;
        }

        @Override
        public int getCount() {
            return items.size();
        }

        @Override
        public DropDownItems getItem(int position) {
            return items.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            DropDownItems item = getItem(position);

            if(convertView==null){
                LayoutInflater inflater = (LayoutInflater) context
                        .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.drop_down_item_row, null);
            }

            final TextView itemText = (TextView) convertView.findViewById(R.id.dropDownItemName);
            final Button itemImage = (Button) convertView.findViewById(R.id.dropDownItemImage);

            itemText.setText(item.getTxt());
            itemText.setTag(item.getTxt());
            itemImage.setText(String.valueOf(item.getValue()));
            itemImage.setTag(item.getTxt());

            if(!item.getShowValue()) {
                itemImage.setVisibility(View.GONE);
            } else {
                itemImage.setVisibility(View.VISIBLE);
            }

            itemText.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(), "Clicked "+itemText.getTag(), Toast.LENGTH_LONG).show();

                    if(popupWindow!=null && popupWindow.isShowing()) {
                        popupWindow.dismiss();
                        popupWindow = null;
                    }

                }
            });

            return convertView;
        }
    }

}