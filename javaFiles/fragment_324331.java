ViewPager.addOnPageChangeListener(pageChangeListener);

   // do this in a runnable to make sure the viewPager's views are already instantiated before triggering the onPageSelected call
   viewpager.post(new Runnable()
   {
       @Override
       public void run() 
       {
           pageChangeListener .onPageSelected(viewPager.getCurrentItem());
       }
   });