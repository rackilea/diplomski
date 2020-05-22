import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
public class ServiceAdapter extends BaseAdapter {
ArrayList<Service> actorList;
LayoutInflater vi;
Context context;

public ServiceAdapter(Context context,ArrayList<Service> objects) {
    this.context= context;
    this.vi = (LayoutInflater) context
            .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    this.actorList = objects;
}


@Override
public View getView(final int position, View convertView, ViewGroup parent) {
    // convert view = design
    final ViewHolder holder;
    if (convertView == null) {
        holder = new ViewHolder();
        convertView = vi.inflate(R.layout.list_row, null);

        holder.tvName = (TextView) convertView.findViewById(R.id.textView1);
        holder.checkBox = (CheckBox) convertView.findViewById(R.id.cbBox);

        convertView.setTag(holder);
    } else
        holder = (ViewHolder) convertView.getTag();

    holder.tvName.setText(actorList.get(position).getName());
    holder.checkBox.setChecked(actorList.get(position).isSelected());

    holder.checkBox.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            boolean isSelected = ((CheckBox)v).isChecked();
            actorList.get(position).setSelected(isSelected);
        }
    });

    return convertView;

}


static class ViewHolder {

    public TextView tvName;
    public CheckBox checkBox;

}


@Override
public int getCount() {
    // TODO Auto-generated method stub
    return actorList.size();
}


@Override
public Object getItem(int position) {
    // TODO Auto-generated method stub
    return actorList.get(position);
}


@Override
public long getItemId(int position) {
    // TODO Auto-generated method stub
    return position;
}

public ArrayList<Service> getSelectActorList(){
    ArrayList<Service> list = new ArrayList<>();
    for(int i=0;i<actorList.size();i++){
        if(actorList.get(i).isSelected())
            list.add(actorList.get(i));
    }
    return list;
}