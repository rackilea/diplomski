public class CustomAdapter extends BaseAdapter {

private final LayoutInflater inflater;
private List<MyObjectClass> list;

public CustomAdapter(Activity activity, List<MyObjectClass> list) {
    this.list = list;
    inflater = LayoutInflater.from(activity);
}

@Override
public int getCount() {
    return list.size();
}

@Override
public MyObjectClass getItem(int position) {
    return list.get(position);
}

@Override
public long getItemId(int position) {
    return position;
}

@Override
public View getView(int position, View convertView, ViewGroup parent) {

    ViewHolder viewHolder = null;

    if (convertView == null) {
        convertView = inflater.inflate(R.layout.listview_item, null);
        viewHolder = new ViewHolder(convertView);
        convertView.setTag(viewHolder);
    } else {
        viewHolder = (ViewHolder) convertView.getTag();
    }
    MyObjectClass object = list.get(position);
    viewHolder.updateData(object);

    return convertView;
}

private class ViewHolder {

    private TextView tvQuantity;
    private TextView tvID;
    private View convertView;
    private TextView tvCode, tvPrice, tvBrand, tvCategory, tvDescription;


    public ViewHolder(View convertView) {
        this.convertView = convertView;
        tvQuantity = (TextView) convertView.findViewById(R.id.Quantity);
        tvID = (TextView) convertView.findViewById(R.id.ID);
        tvBrand = (TextView) convertView.findViewById(R.id.Brand);
        tvCategory = (TextView) convertView.findViewById(R.id.Category);
        tvDescription = (TextView) convertView.findViewById(R.id.Description);
        tvCode = (TextView) convertView.findViewById(R.id.Code);
        tvPrice = (TextView) convertView.findViewById(R.id.Price);
    }

    public void updateData(MyObjectClass object) {
        int quantity = object.getQuantity();
        if (quantity < 3) {
            convertView.setBackgroundColor(Color.BLUE);
        } else {
            //Here your color value should same as default color of listView
            convertView.setBackgroundColor(Color.WHITE);
        }
        tvQuantity.setText(String.valueOf(quantity) + "Gal");
        tvID.setText(object.getDescription());
        tvBrand.setText(object.getBrand());
        tvCategory.setText(object.getCategory());
        tvDescription.setText(object.getDescription());
        tvCode.setText(object.getCode());
        tvPrice.setText(object.getPrice());
    }
  }
}