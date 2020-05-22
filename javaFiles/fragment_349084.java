public class MyPagerAdapter extends PagerAdapter {

        // State number of pages
        public int getCount() {
            return 5;
        }

        // Set each screen's content
        @Override
        public Object instantiateItem(View container, int position) {
            Context context = container.getContext();
            LinearLayout layout = new LinearLayout(context);
            // Add elements
            TextView textItem = new TextView(context);

            buttonItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent("com.phone");
                   // myFancyMethod(v);
                }
            });


            switch (position) {
            case 0:
               textItem.setText("First Screen");
               break;
            case 1:
               textItem.setText("Second Screen");
               break;
            case 2:
                textItem.setText("Third Screen");
                break;


  case 3:
            textItem.setText("Fourth Screen");
            break;
        case 4:
            textItem.setText("Fifth Screen");
            break;
        }
        layout.addView(textItem);
        ((ViewPager) container).addView(layout, 0); // This is the line I added
        return layout;
    }
    @Override
    public void destroyItem(View arg0, int arg1, Object arg2) {
        ((ViewPager) arg0).removeView((View) arg2);
    }
    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return arg0 == ((View) arg1);
    }
    @Override
    public Parcelable saveState() {
        return null;
    }
}