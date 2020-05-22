package com.td.gridview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class MainActivity extends Activity {

    private GridView photoGrid;
    private int mPhotoSize, mPhotoSpacing;
    private ImageAdapter imageAdapter;

    // Some items to add to the GRID
    private static final String[] CONTENT = new String[] 
            { 
            "Akon", "Justin Bieber", "AlRight", "Big Sean",
            "Britney Spears", "Hilary", "Micheal Buble", "Akon", "Justin Bieber", "AlRight", "Big Sean",
            "Britney Spears", "Hilary", "Micheal Buble", "Britney Spears", "Hilary", "Micheal Buble", "Akon",
            "Justin Bieber", "AlRight", "Big Sean", "Britney Spears", "Hilary", "Micheal Buble", "Akon",
            "Justin Bieber", "AlRight", "Big Sean", "Britney Spears", "Hilary", "Micheal Buble", "Akon",
            "Justin Bieber", "AlRight", "Big Sean", "Britney Spears", "Hilary", "Micheal Buble", "Britney Spears",
            "Hilary", "Micheal Buble", "Akon", "Justin Bieber", "AlRight", "Big Sean", "Britney Spears", "Hilary",
            "Micheal Buble" 
            };
    static final int[] ICONS = new int[] 
            { 
            R.drawable.cover_akon, R.drawable.cover_justin,
            R.drawable.cover_alright, R.drawable.cover_big_sean, R.drawable.cover_britney, R.drawable.cover_hilary,
            R.drawable.cover_mb, R.drawable.cover_akon, R.drawable.cover_justin, R.drawable.cover_alright,
            R.drawable.cover_big_sean, R.drawable.cover_britney, R.drawable.cover_hilary, R.drawable.cover_mb,
            R.drawable.cover_britney, R.drawable.cover_hilary, R.drawable.cover_mb, R.drawable.cover_akon,
            R.drawable.cover_justin, R.drawable.cover_alright, R.drawable.cover_big_sean, R.drawable.cover_britney,
            R.drawable.cover_hilary, R.drawable.cover_mb, R.drawable.cover_akon, R.drawable.cover_justin,
            R.drawable.cover_alright, R.drawable.cover_big_sean, R.drawable.cover_britney, R.drawable.cover_hilary,
            R.drawable.cover_mb, R.drawable.cover_akon, R.drawable.cover_justin, R.drawable.cover_alright,
            R.drawable.cover_big_sean, R.drawable.cover_britney, R.drawable.cover_hilary, R.drawable.cover_mb,
            R.drawable.cover_britney, R.drawable.cover_hilary, R.drawable.cover_mb, R.drawable.cover_akon,
            R.drawable.cover_justin, R.drawable.cover_alright, R.drawable.cover_big_sean, R.drawable.cover_britney,
            R.drawable.cover_hilary, R.drawable.cover_mb 
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get the photo size and spacing
        mPhotoSize = getResources().getDimensionPixelSize(R.dimen.photo_size);
        mPhotoSpacing = getResources().getDimensionPixelSize(R.dimen.photo_spacing);

        // initialize image adapter
        imageAdapter = new ImageAdapter();

        photoGrid = (GridView) findViewById(R.id.albumGrid);

        //start sent image to full screen             

        /**
         * On Click event for Single Gridview Item
         * */
        photoGrid.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v,
                    int position, long id) {

                // Sending image id to FullScreenActivity
                Intent i = new Intent(getApplicationContext(), SwipeActivity.class);
                // passing array index
                i.putExtra("id", position);
                startActivity(i);
            }
        });
        //end sent image to full screen

        // set image adapter to the GridView
        photoGrid.setAdapter(imageAdapter);

        // get the view tree observer of the grid and set the height and numcols dynamically
        photoGrid.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                if (imageAdapter.getNumColumns() == 0) {
                    final int numColumns = (int) Math.floor(photoGrid.getWidth() / (mPhotoSize + mPhotoSpacing));
                    if (numColumns > 0) {
                        final int columnWidth = (photoGrid.getWidth() / numColumns) - mPhotoSpacing;
                        imageAdapter.setNumColumns(numColumns);
                        imageAdapter.setItemHeight(columnWidth);

                    }
                }
            }
        });
    }

    // ///////// ImageAdapter class /////////////////
    public class ImageAdapter extends BaseAdapter {
        private LayoutInflater mInflater;
        private int mItemHeight = 0;
        private int mNumColumns = 0;
        private RelativeLayout.LayoutParams mImageViewLayoutParams;

        public ImageAdapter() {
            mInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            mImageViewLayoutParams = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT,
                    LayoutParams.MATCH_PARENT);
        }

        public int getCount() {
            return CONTENT.length;
        }

        // set numcols
        public void setNumColumns(int numColumns) {
            mNumColumns = numColumns;
        }

        public int getNumColumns() {
            return mNumColumns;
        }

        // set photo item height
        public void setItemHeight(int height) {
            if (height == mItemHeight) {
                return;
            }
            mItemHeight = height;
            mImageViewLayoutParams = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, mItemHeight);
            notifyDataSetChanged();
        }

        public Object getItem(int position) {
            return position;
        }

        public long getItemId(int position) {
            return position;
        }

        public View getView(final int position, View view, ViewGroup parent) {

            if (view == null)
                view = mInflater.inflate(R.layout.photo_item, null);

            ImageView cover = (ImageView) view.findViewById(R.id.cover);
            TextView title = (TextView) view.findViewById(R.id.title);

            cover.setLayoutParams(mImageViewLayoutParams);

            // Check the height matches our calculated column width
            if (cover.getLayoutParams().height != mItemHeight) {
                cover.setLayoutParams(mImageViewLayoutParams);
            }

            cover.setImageResource(ICONS[position % ICONS.length]);
            title.setText(CONTENT[position % CONTENT.length]);

            return view;
        }
    }

}