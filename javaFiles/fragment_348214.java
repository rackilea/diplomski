public class CustomAdapter extends ArrayAdapter<Records> {

Context context;
int layoutResourceId;
List<Records> data;


public CustomAdapter(Context context, int layoutResourceId, ArrayList<Records> data) {
    super(context, layoutResourceId, data);
    // TODO Auto-generated constructor stub
    this.layoutResourceId = layoutResourceId;
    this.context = context;
    this.data=data;

}

@Override
public View getView(int position, View convertView, ViewGroup parent) {
    // TODO Auto-generated method stub

    View row = convertView;
    DataHolder holder = null;

    if (row == null) {
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        row = inflater.inflate(layoutResourceId, parent, false);

        holder = new DataHolder();
        holder.dataName = (TextView)row.findViewById(R.id.dataName);
        holder.dataType = (TextView)row.findViewById(R.id.dataType);

        row.setTag(holder);
    } else {
        holder = (DataHolder)row.getTag();
    }

    Records records = data.get(position);
    holder.dataName.setText(records.getName());
    holder.dataType.setText(records.getType());

    return row;
}

static class DataHolder {
    TextView dataName;
    TextView dataType;
}