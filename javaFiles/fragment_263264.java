package com.comp.easybuy.easybuy;

    import android.app.Activity;
    import android.support.v7.app.AppCompatActivity;
    import android.content.Context;
    import android.content.Intent;
    import android.support.v4.view.PagerAdapter;
    import android.support.v4.view.ViewPager;
    import android.support.v7.app.AppCompatActivity;
    import android.os.Bundle;
    import android.view.Menu;
    import android.view.MenuItem;
    import android.view.View;
    import android.view.View.OnClickListener;
    import android.view.ViewGroup;
    import android.widget.ImageButton;
    import android.widget.ImageView;
    import static android.net.Uri.parse;

    public class MainActivity extends Activity {

        private ImageButton callusphone;
        private ImageButton imageFb;
        private ImageButton imageInsta;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
            ImagePagerAdapter adapter = new ImagePagerAdapter();
            viewPager.setAdapter(adapter);
            callusphone=(ImageButton)findViewById(R.id.callus);

            imageFb=(ImageButton)findViewById(R.id.imageButton);
            imageInsta=(ImageButton)findViewById(R.id.insta);

            callusphone.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent callIntent = new Intent(Intent.ACTION_CALL, parse("tel:+962796880853"));
                    startActivity(callIntent);
                }
            });

            imageFb.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    flick(v);
                }
            });
            imageInsta.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    incline(v);
                }
            });

        }

        public void flick(View view){
            Intent bowsprit =new Intent(Intent.ACTION_VIEW, parse("http://www.facebook.com/ebuy2015/"));
            startActivity(bowsprit);

        }
        public void incline(View view){
            Intent browbeaten =new Intent(Intent.ACTION_VIEW, parse("http://www.instagram.com/easy_buy_1/"));
            startActivity(browbeaten);

        }


        private class ImagePagerAdapter extends PagerAdapter {
            private int[] mImages = new int[] {
                    R.drawable.offer4,
                    R.drawable.offer5,
                    R.drawable.offer6,
            };
            @Override
            public int getCount() {
                return mImages.length;
            }
            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                Context context = MainActivity.this;
                ImageView imageView = new ImageView(context);
                int padding =context.getResources().
                        getDimensionPixelSize(R.dimen.abc_switch_padding);
                imageView.setPadding(padding, padding, padding, padding);
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                imageView.setImageResource(mImages[position]);
                container.addView(imageView, 0);
                return imageView;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView((ImageView) object);
            }


            }
        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.menu_main, menu);
            return true;
        }
        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            // Handle action bar item clicks here. The action bar will
            // automatically handle clicks on the Home/Up button, so long
            // as you specify a parent activity in AndroidManifest.xml.
            int id = item.getItemId();
            //noinspection SimplifiableIfStatement
            if (id == R.id.action_settings) {
                return true;
            }
            return super.onOptionsItemSelected(item);
        }
    }