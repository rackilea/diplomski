public static void prepare( IThing thing ) {
     ActionBar bar = thing.getActionBar();
     assert bar != null;
     bar.setIcon(android.R.color.transparent);
     EventBus.getDefault().register(this);
     thing.checkGPS();
}