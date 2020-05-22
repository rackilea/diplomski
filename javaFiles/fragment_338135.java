private View createLayoutContainer(){
  LinearLayout layoutContainer = new LinearLayout(getApplicationContext());
  RelativeLayout relativeLayout = new RelativeLayout(getApplicationContext());

  TextView textWord = new TextView(getApplicationContext());
  ...
  return layoutContainer;
}

public void onCLick_Add(View v){
  layoutScroll.addView(createLayoutContainer());
  layoutScroll.addView(createTextEmptyView());
}