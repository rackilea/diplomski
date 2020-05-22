package fr.nf.smsplus;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Nicolas on 20/05/2016.
 */
public class conversationAdapter extends BaseAdapter {

    Context context;
    ArrayList<Message> conv;
    private static LayoutInflater inflater = null;

    public conversationAdapter(Context context, ArrayList<Message> conv) {
        // TODO Auto-generated constructor stub
        this.context = context;
        this.conv = conv;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return conv.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return conv.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        Message mMessage=conv.get(position);
        View vi = convertView;
        if (vi == null)
            vi = inflater.inflate(R.layout.item_bubble_me, null);
        TextView text = (TextView) vi.findViewById(R.id.txtMsg);
        text.setText(mMessage.content);
        return vi;
    }
}