import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<MenuObject> objects = new ArrayList<MenuObject>();

        for(int i = 0; i <= 50; i++)
        {
            MenuObject tempObject;
            if(i % 5 == 0)
            tempObject = new MenuObject
                    (MenuObject.ObjectType.Category_Header, "Category " + i, "0");

            else tempObject = new MenuObject
                    (MenuObject.ObjectType.Food_Item, "Item " + i, "0");

            objects.add(tempObject);
        }

        ListAdapter theAdapter = new MenuAdapter(this, objects);
        ListView theListView = (ListView) findViewById(R.id.listView1);
        theListView.setAdapter(theAdapter);
    }

    class MenuAdapter extends ArrayAdapter<MenuObject> {

        public MenuAdapter(Context context, ArrayList<MenuObject> values) {
            super(context, R.layout.row_layout, values);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater theInflater = LayoutInflater.from(getContext());
            View theView = theInflater.inflate(R.layout.row_layout, parent, false);

            MenuObject obj = getItem(position);

            if(obj.m_Type == MenuObject.ObjectType.Category_Header) {
                TextView theTextView = (TextView) theView.findViewById(R.id.textView1);
                theTextView.setText(obj.m_Name);
                theView.setBackgroundColor(Color.parseColor("#FFB51202"));
            }

            else {
                TextView theTextView = (TextView) theView.findViewById(R.id.textView1);
                theTextView.setText(obj.m_Name);
            }

            return theView;
        }
    }
}