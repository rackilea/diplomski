import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
public class ContactAdapter extends ArrayAdapter<ContactsObject> {
    private Context context;
    private List<ContactsObject> contactslist;
    public ContactAdapter(Context context, ArrayList<ContactsObject> list) {
        // super(context,R.layout.ctninforow,list);
        super(context, 0, list);
        // super(context, 0, users);
        this.context = context;
        this.contactslist = list;
    }
    public class ViewHolder {
        TextView tvname, tvemail, tvphone;
        public ViewHolder(View v) {
            tvname = (TextView) v.findViewById(R.id.ctnname);
            tvemail = (TextView) v.findViewById(R.id.ctnemail);
            tvphone = (TextView) v.findViewById(R.id.ctnphone);
        }
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder myholder = null;
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.ctninforow, parent, false);
            myholder = new ViewHolder(convertView);
            convertView.setTag(myholder);
        } else {
            myholder = (ViewHolder) convertView.getTag();
        }
        myholder.tvname.setText(contactslist.get(position).name);
        myholder.tvemail.setText(contactslist.get(position).email);
        myholder.tvphone.setText(contactslist.get(position).phone);
        return convertView;
}}