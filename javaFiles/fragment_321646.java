package com.example.listviewwithselectallcheckbxox;

//import it.sephiroth.android.library.widget.AdapterView;
//import it.sephiroth.android.library.widget.AdapterView.OnItemClickListener;
//import it.sephiroth.android.library.widget.HListView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageLoadingListener;
import com.nostra13.universalimageloader.core.assist.SimpleImageLoadingListener;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;

public class MainActivity extends Activity{
    DisplayImageOptions options;
    ArrayList<Integer> checkedPositions = new ArrayList<Integer>();
    boolean flag = false;
    CheckBox selectAll;
    private static final String LOG_TAG = "MainActivity";
    ListView listView;
    TestAdapter mAdapter;
    List<RowItem> rowItems;
    public static final String[] url = {"https://lh6.googleusercontent.com/-55osAWw3x0Q/URquUtcFr5I/AAAAAAAAAbs/rWlj1RUKrYI/s1024/A%252520Photographer.jpg",
        "https://lh4.googleusercontent.com/--dq8niRp7W4/URquVgmXvgI/AAAAAAAAAbs/-gnuLQfNnBA/s1024/A%252520Song%252520of%252520Ice%252520and%252520Fire.jpg",
        "https://lh5.googleusercontent.com/-7qZeDtRKFKc/URquWZT1gOI/AAAAAAAAAbs/hqWgteyNXsg/s1024/Another%252520Rockaway%252520Sunset.jpg",
        "https://lh3.googleusercontent.com/--L0Km39l5J8/URquXHGcdNI/AAAAAAAAAbs/3ZrSJNrSomQ/s1024/Antelope%252520Butte.jpg",
        "https://lh6.googleusercontent.com/-8HO-4vIFnlw/URquZnsFgtI/AAAAAAAAAbs/WT8jViTF7vw/s1024/Antelope%252520Hallway.jpg",
        "https://lh4.googleusercontent.com/-WIuWgVcU3Qw/URqubRVcj4I/AAAAAAAAAbs/YvbwgGjwdIQ/s1024/Antelope%252520Walls.jpg",
        "https://lh6.googleusercontent.com/-UBmLbPELvoQ/URqucCdv0kI/AAAAAAAAAbs/IdNhr2VQoQs/s1024/Apre%2525CC%252580s%252520la%252520Pluie.jpg",
        "https://lh3.googleusercontent.com/-s-AFpvgSeew/URquc6dF-JI/AAAAAAAAAbs/Mt3xNGRUd68/s1024/Backlit%252520Cloud.jpg",
        "https://lh5.googleusercontent.com/-bvmif9a9YOQ/URquea3heHI/AAAAAAAAAbs/rcr6wyeQtAo/s1024/Bee%252520and%252520Flower.jpg",
        "https://lh5.googleusercontent.com/-n7mdm7I7FGs/URqueT_BT-I/AAAAAAAAAbs/9MYmXlmpSAo/s1024/Bonzai%252520Rock%252520Sunset.jpg",
        "https://lh6.googleusercontent.com/-4CN4X4t0M1k/URqufPozWzI/AAAAAAAAAbs/8wK41lg1KPs/s1024/Caterpillar.jpg",
    "https://lh3.googleusercontent.com/-rrFnVC8xQEg/URqufdrLBaI/AAAAAAAAAbs/s69WYy_fl1E/s1024/Chess.jpg"};

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getApplicationContext())
        .build();
        ImageLoader.getInstance().init(config);

        listView = (ListView) findViewById( R.id.hListView1 );
        selectAll = (CheckBox) findViewById(R.id.selectall);
        rowItems = new ArrayList<RowItem>();
        options = new DisplayImageOptions.Builder()
        .showImageOnLoading(R.drawable.ic_stub)
        .showImageForEmptyUri(R.drawable.ic_empty)
        .showImageOnFail(R.drawable.ic_error)
        .cacheInMemory(true)
        .displayer(new RoundedBitmapDisplayer(0))
        .cacheOnDisc(true)
        .build();


        for (int i = 0; i < url.length; i++) {
            RowItem item = new RowItem(url[i]);
            rowItems.add(item);
        }
        mAdapter = new TestAdapter(this,R.layout.list_item, rowItems);
        listView.setHeaderDividersEnabled( true );
        listView.setFooterDividersEnabled( true );
        listView.setAdapter( mAdapter );

        selectAll.setOnCheckedChangeListener(new OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                flag = !flag;
                mAdapter.notifyDataSetChanged();
            }
        });
        listView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View view, int position,
                    long arg3) {
                Toast.makeText(getApplicationContext(), position+"", Toast.LENGTH_SHORT).show();
                CheckBox check = (CheckBox)view.findViewById(R.id.radio);
                final Integer index = Integer.valueOf(position);

                if(!checkedPositions.contains(index))
                    checkedPositions.add(index);
                else
                    checkedPositions.remove(index);

                check.setChecked(checkedPositions.contains(index));             
            }
        });

        Log.i( LOG_TAG, "choice mode: " + listView.getChoiceMode() );
    }



    public class TestAdapter extends ArrayAdapter<RowItem> {

        private ImageLoadingListener animateFirstListener = new AnimateFirstDisplayListener();
        Context context;
        protected ImageLoader imageLoader = ImageLoader.getInstance();

        public TestAdapter(Context context, int resourceId,
                List<RowItem> items) {
            super(context, resourceId, items);
            this.context = context;
        }

        /*private view holder class*/
        private class ViewHolder {
            ImageView imageView;
            CheckBox radio1;
        }

        @Override
        public int getViewTypeCount() {
            return 3;
        }

        @Override
        public int getItemViewType( int position ) {
            return position%3;
        }
        ViewHolder holder=null;
        @Override
        public View getView(final int position, View convertView, ViewGroup parent ) {
            RowItem rowItem = getItem(position);
            holder = new ViewHolder();
            final int i = position;
            if (convertView == null) {

                LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
                convertView = mInflater.inflate(R.layout.list_item, null);
                holder.imageView = (ImageView) convertView.findViewById(R.id.icon);
                holder.radio1 = (CheckBox) convertView.findViewById(R.id.radio);
                convertView.setTag(holder);
            } 
            else{
                holder = (ViewHolder) convertView.getTag();
            }

            holder.radio1.setChecked(flag);
            if(flag){
                if(!checkedPositions.contains(position))
                    checkedPositions.add(position);
            }
            else
            {
                checkedPositions.clear();
            }
            final Integer index = Integer.valueOf(position);

            holder.radio1.setOnCheckedChangeListener(new OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(CompoundButton arg0, boolean isChecked) {
                    if(isChecked){
                        if(!checkedPositions.contains(index))
                            checkedPositions.add(index);
                    }
                    else
                        checkedPositions.remove(index);


                }
            });

            imageLoader.displayImage(rowItem.getimageUrl(), holder.imageView, options, animateFirstListener);
            holder.radio1.setChecked(checkedPositions.contains(index));
            return convertView;
        }
    }
    private static class AnimateFirstDisplayListener extends SimpleImageLoadingListener {

        static final List<String> displayedImages = Collections.synchronizedList(new LinkedList<String>());

        @Override
        public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
            if (loadedImage != null) {
                ImageView imageView = (ImageView) view;
                boolean firstDisplay = !displayedImages.contains(imageUri);
                if (firstDisplay) {
                    FadeInBitmapDisplayer.animate(imageView, 5000);
                    displayedImages.add(imageUri);
                }
            }
        }
    }
}