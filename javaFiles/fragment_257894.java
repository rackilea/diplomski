package com.example.stopwatchmulti;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CustomListview extends ArrayAdapter<String> {


    private String[] userNr;
    private String[] userName;
    private String[] userZeit;

    private Activity context;

    public CustomListview(Activity context, String[] userNr, String[] userName, String[] userZeit) {
        super(context, R.layout.usertableobjects,userNr);

        this.context    = context;
        this.userNr     = userNr;
        this.userName   = userName;
        this.userZeit   = userZeit;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View r = convertView;
        Viewholder viewholder = null;
        if (r==null){

            LayoutInflater inflater = context.getLayoutInflater();
            r=inflater.inflate(R.layout.usertableobjects,null, true);
            viewholder=new Viewholder(r);
            r.setTag(viewholder);
        }
        else{
            viewholder = (Viewholder) r.getTag();
        }

        viewholder.tv1.setText(userNr[position]);
        viewholder.tv2.setText(userName[position]);
        viewholder.tv3.setText(userZeit[position]);

        return r;

    }

    class Viewholder{

        TextView tv1;
        TextView tv2;
        TextView tv3;
        Viewholder(View v) {

            tv1 = v.findViewById(R.id.textViewNummer);
            tv2 = v.findViewById(R.id.textViewName);
            tv3 = v.findViewById(R.id.textViewZeit);

        }

    }
}