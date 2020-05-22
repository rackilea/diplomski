package com.xxx.xxx;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class OzelAdapter extends BaseAdapter {

    private LayoutInflater mInflater;
    private ArrayList<String[]> mKisiListesi;

    public OzelAdapter(Activity activity, ArrayList<String[]> kisiler) {
        //XML'i alıp View'a çevirecek inflater'ı örnekleyelim
        mInflater = (LayoutInflater) activity.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
        //gösterilecek listeyi de alalım
        mKisiListesi = kisiler;
    }

    @Override
    public int getCount() {
        return mKisiListesi.size();
    }

    @Override
    public Object getItem(int position) {
        //şöyle de olabilir: public Object getItem(int position)
        return mKisiListesi.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View satirView;

        satirView = mInflater.inflate(R.layout.lst_layout, null);
        TextView textView1 =
                (TextView) satirView.findViewById(R.id.lstLayout1);
        TextView textView2 =
                (TextView) satirView.findViewById(R.id.lstLayout2);
        TextView textView3 =
                (TextView) satirView.findViewById(R.id.lstLayout3);
        TextView textView4 =
                (TextView) satirView.findViewById(R.id.lstLayout4);

        textView1.setText(mKisiListesi.get(position)[0]);
        textView2.setText(mKisiListesi.get(position)[1]);
        textView3.setText(mKisiListesi.get(position)[2]);
        textView4.setText(mKisiListesi.get(position)[3]);

        return satirView;
    }
}