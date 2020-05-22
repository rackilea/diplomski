package com.mavenmaverick.listviewtest;

     import android.app.ListActivity;
     import android.widget.ListView;

     public class ActivityExample extends ListActivity{

          static final String[] CHOICES = new String[]{

                 "Activity 1",
                 "Activity 2",
                 "Activity 3"
          };

     @Override
     protected void onCreate(Bundle savedInstanceState) {                    
             super.onCreate(savedInstanceState);

          setListAdapter(new ArrayAdapter<String>(new ArrayAdapter<String>(this,
                            android.R.layout.simple_list_item_1,CHOICES));   
          getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
          getListView().setTextFilterEnabled(true);
     }
}