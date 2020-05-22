package com.example.pix.shoping;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Movie> movieList = new ArrayList<>();
    private RecyclerView recyclerView;
    private MoviesAdapter mAdapter;
    private TextView subTotal;
    private double mSubTotal = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mAdapter = new MoviesAdapter(movieList);

        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);

        recyclerView.setItemAnimator(new DefaultItemAnimator());

        recyclerView.setAdapter(mAdapter);

        prepareMovieData();


        subTotal = (TextView) findViewById(R.id.sub_total);

        // This whould be called on a user action mostly like a button click
        mSubTotal = mAdapter.grandTotal();
        subTotal.setText("ØªÙˆÙ…" + String.valueOf(mSubTotal) + " Ù‚ÛŒÙ…Øª Ú©Ù„");
    }

    /**
     * Prepares sample data to provide data set to adapter
     */
    private void prepareMovieData() {
        Movie movie = new Movie("Mad Max: Fury Road", "Action & Adventure", 2015);
        movieList.add(movie);

        movie = new Movie("Inside Out", "Animation, Kids & Family", 2015);
        movieList.add(movie);

        movie = new Movie("Star Wars: Episode VII - The Force Awakens", "Action", 2015);
        movieList.add(movie);

        movie = new Movie("Shaun the Sheep", "Animation", 2015);
        movieList.add(movie);

        // notify adapter about data set changes
        // so that it will render the list with new data
        mAdapter.notifyDataSetChanged();
    }

}