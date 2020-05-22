package com.example.pbp22.dogbreed;

import android.app.LoaderManager;
import android.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{

    ListView list;

    LoaderManager.LoaderCallbacks<List<String>> breedNameLoaderCallbacks;
    LoaderManager.LoaderCallbacks<List<Breed>> breedLoaderCallbacks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (ListView) findViewById(R.id.list);

        breedLoaderCallbacks = new LoaderManager.LoaderCallbacks<List<Breed>>() {
            @Override
            public Loader<List<Breed>> onCreateLoader(int i, Bundle bundle) {

                List<String> breedNames = null;

                if (bundle != null) {
                    breedNames = new ArrayList<>(bundle.getStringArrayList("breed_name"));
                }

                return new BreedLoader(MainActivity.this, breedNames);
            }

            @Override
            public void onLoadFinished(Loader<List<Breed>> loader, List<Breed> products) {


                if (products != null && !products.isEmpty()) {
                    Log.v("DogXXX", products.toString());
                    CustomAdapter adapter = new CustomAdapter(
                            getApplicationContext(), R.layout.list_row, products
                    );
                    list.setAdapter(adapter);
                }
            }

            @Override
            public void onLoaderReset(Loader<List<Breed>> loader) {

            }
        };

        breedNameLoaderCallbacks = new LoaderManager.LoaderCallbacks<List<String>>() {
            @Override
            public Loader<List<String>> onCreateLoader(int i, Bundle bundle) {
                return new BreedNameLoader(MainActivity.this);
            }

            @Override
            public void onLoadFinished(Loader<List<String>> loader, List<String> strings) {

                Bundle breedNameBundle = new Bundle();
                breedNameBundle.putStringArrayList("breed_name", (ArrayList<String>) strings);
                getLoaderManager().initLoader(2, breedNameBundle, breedLoaderCallbacks);
            }

            @Override
            public void onLoaderReset(Loader<List<String>> loader) {

            }
        };

        getLoaderManager().initLoader(1, null, breedNameLoaderCallbacks);
    }
}