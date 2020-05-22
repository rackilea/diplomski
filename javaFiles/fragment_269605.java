ViewGroup viewGroup = (ViewGroup) v.getParent();
    for(int i=0;i<viewGroup.getChildCount();i++){
        Object child = viewGroup.getChildAt(i);
        if(child instanceof Button){
            ((Button) child).setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorPrimary));
        }
    }