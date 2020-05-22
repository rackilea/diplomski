public class SoftwarePassionView extends ListActivity {

private ProgressDialog m_progressDialog = null;
private ArrayList<Order> m_orders = new ArrayList<Order>(); //why you have putting it null?
private OrderAdapter m_adapter; // Defined Below
private Runnable viewOrders;

@Override
protected void onCreate(Bundle savedInstanceState) {
    try {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.softwarepassionview);
        m_adapter = new OrderAdapter(SoftwarePassionView.this,
                R.layout.row, m_orders);
        setListAdapter(m_adapter); // you are getting npe as you have not init "m_orders"
        new AsyncOperation().execute();

    } catch (Exception e) {
        Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
    }
}

public class OrderAdapter extends BaseAdapter {

    private ArrayList<Order> items=new ArrayList<Order>();

    public OrderAdapter(Context context, int textViewResourceId,
            ArrayList<Order> elements) {
        //super(context, textViewResourceId, elements);
        this.items = elements;
    }

    public void setList(ArrayList<Order> items) {
        this.items.clear(); 
        this.items.addAll(items);
        this.notifyDataSetChanged();

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        super.getView(position, convertView, parent);
        View v = convertView;
        try {
            if (v == null) {
                LayoutInflater vi = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                v = vi.inflate(R.layout.row, null);
            }
            Order o = items.get(position);
            if (o != null) {
                TextView orderName = (TextView) v
                        .findViewById(R.id.topText);
                TextView orderStatus = (TextView) v
                        .findViewById(R.id.bottomText);
                orderName.setText(o.getOrderName());
                orderStatus.setText(o.getOrderStatus());
            }
        } catch (Exception e) {
            Toast.makeText(SoftwarePassionView.this, e.toString(),
                    Toast.LENGTH_SHORT).show();
        }
        return v;
    }

public int getCount() {

    return this.items.size();
}

public Object getItem(int arg0) {
    // TODO Auto-generated method stub
    return this.items.get(arg0);
}

public long getItemId(int arg0) {
    // TODO Auto-generated method stub
    return 0;
}

}

public class AsyncOperation extends AsyncTask {

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Object doInBackground(Object... params) {
        getOrders();
       // if (m_orders != null && m_orders.size() > 0) {  NO nead to set list here
       //     m_adapter.setList(m_orders);
       // }
        return null;
    }

    @Override
    protected void onPostExecute(Object result) {

        if (m_orders != null && m_orders.size() > 0) {  
            m_adapter.setList(m_orders);
        }
         super.onPostExecute(result);
        //setListAdapter(m_adapter);
    }
}

private void getOrders() {
    try {
        m_orders = new ArrayList<Order>();
        Order o1 = new Order();
        o1.setOrderName("T-Shirt Purchase");
        o1.setOrderStatus("Dispatched");
        Order o2 = new Order();
        o2.setOrderName("Deo Purchase");
        o2.setOrderStatus("Pending");
        m_orders.add(o1);
        m_orders.add(o2);

        Thread.sleep(2000);
    } catch (Exception e) {
        Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
    }
}