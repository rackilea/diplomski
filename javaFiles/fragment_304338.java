package com.davekelley.polling;

import com.actionbarsherlock.R;
import com.actionbarsherlock.app.SherlockFragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MilitaryFragment extends SherlockFragment {

@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.militaryfragment, container, false);
    }
}