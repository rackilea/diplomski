package com.cj.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.LinearLayout;

/**
 * Created by CHETAN JOSHI on 1/31/2017.
 */

public class TestActivity  extends AppCompatActivity{
    LinearLayout mParentLayout;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);
        mParentLayout = (LinearLayout)findViewById(R.id.mParentLayout);
        String [] myList = new String[]{"masukan jenis kursus","Tambah jenis kursus",
                "masukan jenis kursus","masukan jenis kursus","Tambah jenis kursus"};
        addEditTextDynamically(mParentLayout,myList);
    }


    private void addEditTextDynamically(LinearLayout mParentLayout,String [] myList){

        for (int i=0;i<myList.length;i++){
            EditText myEditText = new EditText(mParentLayout.getContext()); //Context
            myEditText.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
            myEditText.setId(i);
            myEditText.setTag(myList[i]);
            mParentLayout.addView(myEditText);
        }
    }

}