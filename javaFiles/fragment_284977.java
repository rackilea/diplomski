public class DemoAdapter extends BaseAdapter {
ArrayList<String> list;
Context context;

String TAG = "adapter";

public DemoAdapter(Context context) {

    this.context = context;
    this.list = new ArrayList<>();
    for(int i=0;i<10;i++){
    this.list.add("0");
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
public View getView(final int position, View convertView, ViewGroup parent) {

    final Holder holder;
    if (convertView == null) {
        convertView = View.inflate(context, R.layout.total_item_layout, null);
        holder = new Holder(convertView);
        convertView.setTag(holder);
    } else holder = (Holder) convertView.getTag();

    holder.total.setText(list.get(position).toString());
    holder.plusBtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int count = Integer.parseInt(list.get(position));
            count = count + 1;
            Log.e(TAG, "onClick: " + count);
            list.set(position, String.valueOf(count));  //update your list like this
            notifyDataSetChanged();
        }
    });
    holder.minusBtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int count = Integer.parseInt(list.get(position));
            if (count > 0) {
                count = count - 1;
                list.set(position, String.valueOf(count)); //update your list like this
            } else Toast.makeText(context, "not allowed", Toast.LENGTH_SHORT).show();
            Log.e(TAG, "onClick: " + count);
            notifyDataSetChanged();
        }
    });


    return convertView;
}


static class Holder {
    TextView total;
    Button plusBtn, minusBtn;

    public Holder(View v) {
        total = (TextView) v.findViewById(R.id.total_text_view);
        plusBtn = (Button) v.findViewById(R.id.plus_btn);
        minusBtn = (Button) v.findViewById(R.id.minus_btn);
    }
}
}