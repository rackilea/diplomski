TypedArray array = getTheme().obtainStyledAttributes(new int[] {  
    android.R.attr.colorBackground, 
    android.R.attr.textColorPrimary, 
}); 
int backgroundColor = array.getColor(0, 0xFF00FF); 
int textColor = array.getColor(1, 0xFF00FF); 
array.recycle();