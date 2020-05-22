package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView mImageView;
    private ImageView m1ImageView;
    private ImageView m2ImageView;

@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImageView = findViewById(R.id.stephen_carvalho_bald);
        m1ImageView = findViewById(R.id.stephen_carvalho_golden_pagoda);
        m2ImageView = findViewById(R.id.stephen_carvalho_hackathon);

        mImageView.setOnClickListener(this);
        m1ImageView.setOnClickListener(this);
        m2ImageView.setOnClickListener(this);

        }

@Override
public void onClick(View v) {
    switch (v.getId()){
        case R.id.stephen_carvalho_bald:
            mImageView.setVisibility(View.INVISIBLE);
            m1ImageView.setVisibility(View.VISIBLE);
            Toast.makeText(this, "You clicked view1", Toast.LENGTH_LONG).show();
            break;
        case R.id.stephen_carvalho_golden_pagoda:
            m1ImageView.setVisibility(View.INVISIBLE);
            m2ImageView.setVisibility(View.VISIBLE);
            Toast.makeText(this, "You clicked view2", Toast.LENGTH_LONG).show();
            break;
        case R.id.stephen_carvalho_hackathon:
            m2ImageView.setVisibility(View.INVISIBLE);
            mImageView.setVisibility(View.VISIBLE);
            Toast.makeText(this, "You clicked view3", Toast.LENGTH_LONG).show();
            break;

         }
      }
   }