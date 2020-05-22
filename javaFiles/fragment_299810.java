@Override
protected void onLayout(boolean changed, int l, int t, int r, int b) {
final Context context = c;

    final int count = this.getChildCount();

    TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.accordion);
    String[] btns = getResources().getStringArray(R.array.buttons);
    ArrayList<LinearLayout> lls = new ArrayList <> (count);

    for(int i = 0; i < count; i++){
        View child = this.getChildAt(i);
        if (child instanceof LinearLayout) {
            lls.add((LinearLayout)child);
        }
    }
.......