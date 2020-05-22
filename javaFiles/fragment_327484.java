public class YourAdapterName extends BaseAdapter{

private Context mContext;
private DataType mValuestoShow;//Use your DataType to pass values to adapter. 

/**
 * Constructor to be called to initialize adapter with values.
 * @param context
 * @param vector
 */
public YourAdapterName(Context context, DataType data){
    mContext = context;
    mValuestoShow = vector;
}

public int getCount() {
    if(null != mValuestoShow){
        return mValuestoShow.size();
    }
    return 0;
}

public Object getItem(int position) {
    if(position < mValuestoShow.size())
        return  mValuestoShow.get(position);
    else
        return null;
}

public long getItemId(int position) {
    return 0;
}



public View getView(int position, View convertView, ViewGroup parent) {
    ViewHolder holder ;
    if(convertView == null){
        LayoutInflater li =(LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = li.inflate(R.layout.your_layout, null);
        holder = new ViewHolder();
        holder.txt_name = (TextView) convertView.findViewById(R.id.name_txt);
        holder.checkBox = (Checkbox) convertView.findViewById(R.id.checkbox);
        convertView.setTag(holder);
    }else{
        holder = (ViewHolder) convertView.getTag();
    }

    holder.txt_name.setText(getItem(position).toString());
    holder.checkBox    // Do your task with checkbox.
    return convertView;
}

class ViewHolder {
    TextView txt_name;
    Checkbox checkBox;
}

}