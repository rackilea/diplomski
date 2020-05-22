ViewGroup group = (ViewGroup)findViewById(R.id.myrootlayout);
View v;
for(int i = 0; i < group.getChildCount(); i++) {
    v = group.getChildAt(i);
    if(v instanceof Button) v.setOnClickListener(this)
}