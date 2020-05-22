public View getCoordinateLayout(Activity activity) {
    ViewGroup vg = (ViewGroup) activity.findViewById(android.R.id.content);
    ViewGroup root = (ViewGroup) vg.getChildAt(0);
    int childCount = root.getChildCount();
    for(int i=0;i<childCount;i++){
        View view = root.getChildAt(i);
        if(view instanceof CoordinatorLayout){
            return view;
        }
    }
    return null;
}