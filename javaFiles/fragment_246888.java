package com.example.pbp22.dogbreed;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;

public class BreedNameLoader extends AsyncTaskLoader<List<String>> {

    /**
     * Tag for log messages
     */
    private static final String LOG_TAG = BreedLoader.class.getName();

    public BreedNameLoader(Context context) {
        super(context);
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    /**
     * This is on a background thread.
     */
    @Override
    public List<String> loadInBackground() {

        // Perform the network request, parse the response, and extract a list of earthquakes.
        return QueryUtils.fetchBreedNameData();
    }
}