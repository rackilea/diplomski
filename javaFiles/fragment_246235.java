package org.example.chad;

import java.util.ArrayList;

import android.app.ListActivity;
import android.os.Bundle;

public class MainActivity extends ListActivity {


private ArrayList<DataItem> data = new ArrayList<DataItem>();

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

    //create Objects
    DataItem obj1 = new DataItem("name1", "record1");
    DataItem obj2 = new DataItem("name2", "record2");
    DataItem obj3 = new DataItem("name3", "record3");
    DataItem obj4 = new DataItem("name4", "record4");
    DataItem obj5 = new DataItem("name5", "record5");
    //add the to ArrayList
    data.add(obj1);
    data.add(obj2);
    data.add(obj3);
    data.add(obj4);
    data.add(obj5);


        CustomAdapter adapter = new CustomAdapter(this, R.layout.row, data);
        setListAdapter(adapter);        

}