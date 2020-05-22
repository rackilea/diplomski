package com.td.gridview;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;



public class SwipeActivity extends Activity 
{   

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.swipe_view);

    ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
    ImagePagerAdapter adapter = new ImagePagerAdapter();
    viewPager.setAdapter(adapter);
  }

  private class ImagePagerAdapter extends PagerAdapter 
  {
      int[] icons = MainActivity.ICONS;    

    @Override
    public int getCount() 
    {
      return icons.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) 
    {
      return view == ((ImageView) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) 
    {
      Context context = SwipeActivity.this;
      ImageView imageView = new ImageView(context);
      int padding = context.getResources().getDimensionPixelSize(
          R.dimen.padding_large);
      imageView.setPadding(padding, padding, padding, padding);
      imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
      imageView.setImageResource(icons[position]);
      ((ViewPager) container).addView(imageView, 0);
      return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) 
    {
      ((ViewPager) container).removeView((ImageView) object);
    }
  }
}