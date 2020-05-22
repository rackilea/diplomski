package com.test.downloadjpgtest;

import java.io.File;
import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class Main extends Activity {
    GridView gridview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // récupère la GridView
        gridview = (GridView) findViewById(R.id.gridview);

        // GetLibraryTask
        DownloadTask downloadTask = new DownloadTask(this);
        downloadTask.execute("http://sphotos-b.xx.fbcdn.net/hphotos-ash4/c0.0.400.400/p403x403/382050_498705510162306_1891776516_n.jpg",
                             "http://data.alipson.fr/ravensburger.17/ravensburger-puzzle-1000-pieces-panoramique-amitie-entre-animaux-.44481-1.jpg",
                             "http://a388.idata.over-blog.com/400x400/3/03/14/36/mammiferes/lynx-canada-04.jpg",
                             "http://photos.ugal.com/6353/43314/205322/246370/vignette-chapeaux-animaux.400.jpg");
    }

    // called well all downloads finished
    public void setGridAdapter(){
        gridview.setAdapter(new ImageAdapter(this));

        gridview.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Toast.makeText(Main.this, "" + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    public class ImageAdapter extends BaseAdapter {
        private Context mContext;
        public Bitmap[] imgs;

        public ImageAdapter(Context c) {
            mContext = c;
            getImages();
        }

        public int getCount() {
            return imgs.length;
        }

        public Object getItem(int position) {
            return imgs[position];
        }

        public long getItemId(int position) {
            return 0;
        }

        // create a new ImageView for each item referenced by the Adapter
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView;
            if (convertView == null) {  // if it's not recycled, initialize some attributes
                imageView = new ImageView(mContext);
                imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setPadding(8, 8, 8, 8);
            } else {
                imageView = (ImageView) convertView;
            }
            imageView.setImageBitmap(imgs[position]);
            return imageView;
        }

        private void getImages(){
            ArrayList<Bitmap> bitmaps = new ArrayList<Bitmap>();
            for (File imgfile : DownloadTask.getImages(this.mContext)) {
               Bitmap bmp = BitmapFactory.decodeFile(imgfile.getAbsolutePath());
               if (bmp != null)
                   bitmaps.add(bmp);
             }
             this.imgs = bitmaps.toArray(new Bitmap[bitmaps.size()]);
        }


    }
}