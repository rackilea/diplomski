package pl.selvin.decoreradapter;

import android.database.DataSetObserver;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    /*** paste the DecorerAdapter class here ***/

    public static class MyListFragment extends ListFragment{
        final ArrayList<String> strings = new ArrayList<>();
        private BaseAdapter innerAdapter;

        @Override
        public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
            menu.add("Add rnd(10) more");

            super.onCreateOptionsMenu(menu, inflater);
        }

        final Random rnd = new Random();
        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            final String[] toAdd = new String[rnd.nextInt(10)];
            int start = strings.size();
            for(int i = 0; i < toAdd.length; i++)
                toAdd[i] = (start + i) + "";
            Collections.addAll(strings, toAdd);
            Toast.makeText(getActivity(), "Added " + toAdd.length + " count: " + strings.size(), Toast.LENGTH_SHORT).show();
            innerAdapter.notifyDataSetChanged();
            return true;
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setHasOptionsMenu(true);
            for(int i = 0; i < 4; i++) {
                strings.add(i + "");
            }
            innerAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, strings);
            setListAdapter(new DecorerAdapter(innerAdapter, 5) {
                @Override
                public View getDecorerView(int position, View convertView, ViewGroup parent) {
                    if(convertView == null) {
                        convertView = new TextView(getActivity());
                        convertView.setBackgroundColor(Color.RED);
                    }
                    ((TextView)convertView).setText("AdView: " + position);
                    return convertView;
                }
            });
        }

        @Override
        public void onListItemClick(ListView l, View v, int position, long id) {
            String item = (String)l.getItemAtPosition(position);
            Toast.makeText(getActivity(), "Item click: " + (item == null ? "ADVIEW" : item), Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(android.R.id.content, new MyListFragment(), "LIST").commit();
        }
    }
}