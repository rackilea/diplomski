public void configureToolbar(Activity activity, int toolbarId) {
 Toolbar toolbar= (Toolbar) activity.findViewById(toolbarId);
   if(toolbar != null) { //credit to @Gabriele Mariotti, I missed this check
   toolbar.setElevation(0);
   toolbar.setTitle("");

   ((AppCompatActivity)activity).setSupportActionBar(toolbar);
 }
}