package com.example.listviewexample;

import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ListActivity {

    String[] phototype={"Family Photography", "Portrait Photography", "Picture People Full Site"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, phototype));
    }

    protected void onListItemClick(ListView l, View v, int position, long id) {
       switch(position){
       case 0:
          startActivity(new Intent(MainActivity.this, Portrait.class));
           break;
       case 1:
           startActivity(new Intent(MainActivity.this, Family.class));
           break;
       case 2:
           startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.picturepeople.com")));
           break;
       }
    }
}