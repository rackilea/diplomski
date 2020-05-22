ListView listView = (ListView)findViewById(R.id.listView);
int count = listView.getChildCount();
for (int x = 0; x < count; x++)
{
    Class<? extends View> c = listView.getChildAt(x).getClass();
    if (c == CheckBox.class)
    {
        CheckBox checkBox = (CheckBox)(listView.getChildAt(x));
        checkBox.setOnCheckedChangeListener(new OnCheckedChangeListener(){

            @Override
            public void onCheckedChanged(CompoundButton compoutButton, boolean isChecked) {
                // TODO Auto-generated method stub
                callBlockOptions.isChecked = isChecked;
            }
        });
    }
    else if (c == TextView.class)
    {
        TextView textView = (TextView)(listView.getChildAt(x));
        textView.setOnEditorActionListener(new OnEditorActionListener(){

            @Override
            public boolean onEditorAction(TextView tView, int arg1, KeyEvent arg2) {
                // TODO Auto-generated method stub
                callBlockOptions.name = tView.getText().toString();
                return true;
            }

        });
    }