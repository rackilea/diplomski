List<Integer> lotoValues = new ArrayList<Integer>();
ViewGroup layout = (ViewGroup) findViewById(R.id.myLayout);
for(int i=0; i<layout.getChildCount(); ++i) {
    ViewLoto nextChild = (ViewLoto) layout.getChildAt(i);
    lotoValues.add((Integer)nextChild.getText());
}