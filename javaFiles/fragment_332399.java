package com.byshy.light.Activities;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.WindowManager;
import com.byshy.light.Adapters.SearchResultsAdapter;
import com.byshy.light.Models.SearchResult;
import com.byshy.light.R;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {

private RecyclerView searchRV;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_search);
    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

    getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);

    searchRV = findViewById(R.id.search_activity_results);
    searchRV.setHasFixedSize(true);
    searchRV.setLayoutManager(new LinearLayoutManager(this));

    ArrayList<SearchResult> results = new ArrayList<>();
    results.add(new SearchResult("Restaurants", 1));
    results.add(new SearchResult("res1"));
    results.add(new SearchResult("res2"));
    results.add(new SearchResult("res3"));
    results.add(new SearchResult("Meals", 1));
    results.add(new SearchResult("meal1"));
    results.add(new SearchResult("meal2"));
    results.add(new SearchResult("meal3"));
    results.add(new SearchResult("meal4"));
    results.add(new SearchResult("meal5"));
    results.add(new SearchResult("meal6"));

    SearchResultsAdapter adapter = new SearchResultsAdapter(results);

    searchRV.setAdapter(adapter);

}

}