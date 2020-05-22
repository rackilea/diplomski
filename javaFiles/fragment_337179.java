package com.primecabs;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.TimePicker;
import com.primecabs.home.Content;

/**
 * A fragment representing a single Cab detail screen. This fragment is either
 * contained in a {@link CabListActivity} in two-pane mode (on tablets) or a
 * {@link CabDetailActivity} on handsets.
 */
public class CabDetailFragment extends Fragment {

    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";
    // Variables for Storing Message & Button objects
    TextView name, from_loc, to_loc, phone, email, dob;
    CheckBox today, tomorrow;
    TimePicker pickup;
    public static final String MyPREFERENCES = "MyPrefs";
    public static final String Name = "nameKey";
    public static final String Phone = "phoneKey";
    public static final String Email = "emailKey";
    public static final String DOB = "dobKey";
    SharedPreferences sharedpreferences;
    /**
     * The dummy content this fragment is presenting.
     */
    private Content.Item mItem;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public CabDetailFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            mItem = Content.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = null;
        sharedpreferences = this.getActivity().getSharedPreferences(
            MyPREFERENCES, Context.MODE_PRIVATE);
        if (mItem.id == "1") {
            rootView = inflater.inflate(R.layout.fragment_cab_detail_book,
                container, false);
            TextView bname = (TextView) rootView.findViewById(R.id.uname);
            TextView bphone = (TextView) rootView.findViewById(R.id.mob_num);
            TextView bemail = (TextView) rootView.findViewById(R.id.email);
            if (sharedpreferences.contains(Name)) {
                bname.setText(sharedpreferences.getString(Name, ""));
            }
            if (sharedpreferences.contains(Phone)) {
                bphone.setText(sharedpreferences.getString(Phone, ""));
            }
            if (sharedpreferences.contains(Email)) {
                bemail.setText(sharedpreferences.getString(Email, ""));
            }
        }
        if (mItem.id == "3") {
            rootView = inflater.inflate(R.layout.fragment_user_profile,
                container, false);
            // Profile Layout Display
            name = (TextView) rootView.findViewById(R.id.prof_uname);
            phone = (TextView) rootView.findViewById(R.id.prof_mob_num);
            email = (TextView) rootView.findViewById(R.id.prof_email);
            dob = (TextView) rootView.findViewById(R.id.prof_dob);
            if (sharedpreferences.contains(Name) == true) {
                name.setText(sharedpreferences.getString(Name, ""));
            }
            if (sharedpreferences.contains(Phone)) {
                (phone).setText(sharedpreferences.getString(Phone, ""));
            }
            if (sharedpreferences.contains(Email)) {
                (email).setText(sharedpreferences.getString(Email, ""));
            }
            if (sharedpreferences.contains(DOB)) {
                (dob).setText(sharedpreferences.getString(DOB, ""));
            }
        }
        if (mItem.id == "2") {
            rootView = inflater.inflate(R.layout.fragment_cab_detail_confirm,
                container, false);
            // Show the content as text in a TextView.
            // if (mItem != null) {
            // ((TextView) rootView.findViewById(R.id.cab_detail))
            // .setText(mItem.content);
        }
        return rootView;
    }
}