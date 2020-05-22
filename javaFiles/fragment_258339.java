ArrayList<TextView> myTextViews = new ArrayList<TextView>();

myTextViews.Add((TextView) findViewByid(R.id.textview1));
myTextViews.Add((TextView) findViewByid(R.id.textview2));
.
.
.
 for(int i=1;i<=11;i++){
    myTextViews.get(i).SetText("some text");
}