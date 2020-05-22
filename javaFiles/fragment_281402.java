private ViewGroup parentView; // Add new Var
 // change/add new constracotr 
 public ReadViewPagerAdapter(Context context,ViewGroup parent) {
    this.mInflater = LayoutInflater.from(context);
    //******
    this.parentView = parent;
    //******
    this.images = new Vector<>(5);
    this.images = getAllImages(Application_TEMP_DIR,
            getFilenameFilter(new String[]{"jpeg"}));

}