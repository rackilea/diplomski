package com.example.myapp;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.*;

public class MyActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        ListView list = (ListView)findViewById(R.id.my_list);
        if (list != null) {
            final List<DemoItem> demoList = new ArrayList<DemoItem>();

            final SimpleDateFormat hourDateFormat = new SimpleDateFormat("HH:mm", Locale.getDefault());
            final Calendar c = Calendar.getInstance();
            final Date now = c.getTime();
            final String now_ = hourDateFormat.format(now);

            demoList.add(0, new DemoItem(now_, "first comment"));
            demoList.add(1, new DemoItem(now_, "second comment"));
            demoList.add(2, new DemoItem(now_, "third comment"));

            DemoAdapter adapter = new DemoAdapter(this, demoList);
            list.setAdapter(adapter);
        }
    }

    class DemoItem {
        public String datetime;
        public String comment;

        public DemoItem(String datetime, String comment) {
            this.datetime = datetime;
            this.comment = comment;
        }
    }

    class DemoAdapter extends ArrayAdapter<DemoItem> {

        public DemoAdapter(Context context, List<DemoItem> items) {
            super(context, R.layout.list_item, items);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            if (convertView == null)
                convertView = getLayoutInflater().inflate(R.layout.list_item, null);

            DemoItem item = super.getItem(position);

            EditText editComment = (EditText)convertView.findViewById(R.id.edit_comment);
            if (editComment != null)
                editComment.setText(item.comment);

            TextView txtDatetime = (TextView)convertView.findViewById(R.id.text_datetime);
            if (txtDatetime != null)
                txtDatetime.setText(item.datetime);

            return convertView;
        }
    }
}