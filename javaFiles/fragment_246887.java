package com.example.pbp22.dogbreed;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;

public class BreedLoader extends AsyncTaskLoader<List<Breed>> {
/**
 * Tag for log messages
 */
private static final String LOG_TAG = BreedLoader.class.getName();

List<String> breedNames;

public BreedLoader(Context context, List<String> breedNames) {
    super(context);
    this.breedNames = breedNames;
}

@Override
protected void onStartLoading() {
    forceLoad();
}

/**
 * This is on a background thread.
 */
@Override
public List<Breed> loadInBackground() {

    // Perform the network request, parse the response, and extract a list of breeds.
    return QueryUtils.fetchBreedData(breedNames);
}
}