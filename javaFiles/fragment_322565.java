private childCount;

// ...

@Override
protected void onCreate(Bundle savedInstanceState) {

    // ...

    final LinearLayout layout = (LinearLayout) findViewById(R.id.yourLayout);

    childCount = layout.getChildCount();

    layout.setOnHierarchyChangeListener(new ViewGroup.OnHierarchyChangeListener() {
        @Override
        public void onChildViewAdded(View parent, View child) {
            childCount++;
          //childCount = layout.getChildCount(); //a safer but slower approach
        }

        @Override
        public void onChildViewRemoved(View parent, View child) {
            childCount--;
          //childCount = layout.getChildCount();
        }
    });
}