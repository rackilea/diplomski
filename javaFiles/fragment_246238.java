package org.example.chad;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class CustomAdapter extends ArrayAdapter<DataItem> {
   private ArrayList<DataItem> objects;

   public CustomAdapter(Context context, int textViewResourceId, ArrayList<DataItem>     objects) {
        super(context, textViewResourceId, objects);
        this.objects = objects;
}

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {

  View v = convertView;
  if (v == null) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inflater.inflate(R.layout.row, null);
    }


  DataItem i = objects.get(position);

if (i != null) {
    TextView nameView = (TextView) v.findViewById(R.id.name);
    TextView recordView = (TextView) v.findViewById(R.id.record);

    if (nameView != null){
        nameView.setText(i.getname());
    }
    if (recordView != null){
        recordView.setText(i.getrecord());
    }

}

return v;
  }
}