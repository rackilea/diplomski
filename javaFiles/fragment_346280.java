LinearLayout layout= (LinearLayout)findViewById(R.id.checkbox_container);
ArrayList values = new ArrayList();
for(int i=0; i<layout.getChildCount(); i++)
{
    View v = layout.getChildAt(i);
    if(v instanceof CheckBox)
    {
        CheckBox cb = (CheckBox)v;
        if(cb.isChecked())
        values.add(cb.getText().toString());
    }
}