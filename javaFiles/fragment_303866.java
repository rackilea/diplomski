public class ConfigureMyOrderItem extends MainActivity {

private ArrayList<ExpandableConfigureGroup> group_list;
private ArrayList<ExpandableConfigureChild> child_list;
ExpandableListView mExpandableListView;
ConfigureMyOrderAdapter adapter;
Button btn_confirm;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_configure_my_order_item);

    initView();

}

public void initView() {
    mExpandableListView = (ExpandableListView) findViewById(R.id.expandableListViewConfigure);
    btn_confirm = (Button) findViewById(R.id.btn_Confirm_order);
    btn_confirm.setOnClickListener(new OnClickListener() {

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(ConfigureMyOrderItem.this,
                    MyOrderActivity.class);
            startActivity(intent);
        }
    });

    group_list = SetStandardGroups();

    adapter = new ConfigureMyOrderAdapter(ConfigureMyOrderItem.this,
            mExpandableListView, group_list);

    mExpandableListView.setAdapter(adapter);
}

@Override
public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater()
            .inflate(R.menu.activity_configure_my_order_item, menu);
    return true;
}

public ArrayList<ExpandableConfigureGroup> SetStandardGroups() {

    group_list = new ArrayList<ExpandableConfigureGroup>();
    child_list = new ArrayList<ExpandableConfigureChild>();

    group_list.add(new ExpandableConfigureGroup("Group", child_list));
    child_list.add(new ExpandableConfigureChild("Child1"));
    child_list.add(new ExpandableConfigureChild("Child2"));
    child_list.add(new ExpandableConfigureChild("Child3"));
    child_list.add(new ExpandableConfigureChild("Child4"));

    child_list = new ArrayList<ExpandableConfigureChild>();
    group_list.add(new ExpandableConfigureGroup("Category",
            child_list));
    child_list.add(new ExpandableConfigureChild("Item1"));
    child_list.add(new ExpandableConfigureChild("Item2"));
    child_list.add(new ExpandableConfigureChild("Item3"));
    child_list.add(new ExpandableConfigureChild("Item4"));

}

public void HomeButton(View v) {
    startActivity(new Intent(v.getContext(), MainActivity.class));
}

@Override
public void onClickQuickView(View v) {
    // TODO Auto-generated method stub
    super.onClickQuickView(v);
}

@Override
public void onClickQuickViewStatus(View v) {
    // TODO Auto-generated method stub
    super.onClickQuickViewStatus(v);
}

}