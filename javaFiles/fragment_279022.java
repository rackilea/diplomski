package com.****.****;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

/**
 * Created by Calvin on 27/12/2014.
 */
public class heroes_Fragment extends Fragment implements OnClickListener{
    Button btnChange;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.heroes_layout, container, false);

        ImageButton btntrac = (ImageButton) view.findViewById(R.id.icontrac);
        btntrac.setOnClickListener(this);
        return view;
    }

    public void onClick(View v) {
        trac(v);
    }
android.support.v4.app.FragmentManager manager;
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        manager=getFragmentManager();

    }

    public void trac(View view) {
        android.support.v4.app.FragmentTransaction transaction =manager.beginTransaction();
        transaction.replace(R.id.container,new trac_Fragment());
        transaction.addToBackStack(null);
        transaction.commit();
    }


}