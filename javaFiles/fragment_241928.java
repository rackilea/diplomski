RelativeLayout mRlayout = (RelativeLayout) findViewById(R.id.checkFieldsLayout);
Bundle extras = getIntent().getExtras();
List<String> fields = extras.getStringArrayList("checkList");

RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
     RelativeLayout.LayoutParams.MATCH_PARENT,
     RelativeLayout.LayoutParams.WRAP_CONTENT);
params.addRule(RelativeLayout.ALIGN_PARENT_TOP); 


TextView header1 = new TextView(this); // Pass it an Activity or Context
header.setText(fields.get(0).toString());
header.setLayoutParams(params);
header1.setId(0);

RelativeLayout.LayoutParams params2 = new RelativeLayout.LayoutParams(
     RelativeLayout.LayoutParams.MATCH_PARENT,
     RelativeLayout.LayoutParams.WRAP_CONTENT);
params2.addRule(RelativeLayout.BELOW,0);

EditText field1 = new EditText(this);
field.setLayoutParams(params2);
field1.setId(fields.size());

mRlayout.addView(header);
mRlayout.addView(field);

for (int i = 1; i < fields.size(); i++) {
    RelativeLayout.LayoutParams params1 = new RelativeLayout.LayoutParams(
         RelativeLayout.LayoutParams.MATCH_PARENT,
         RelativeLayout.LayoutParams.WRAP_CONTENT);
    params2.addRule(RelativeLayout.BELOW,fields.size()+i -1);

    TextView header = new TextView(this); // Pass it an Activity or Context
    header.setText(fields.get(i).toString());
    header.setId(i);
    header.setLayoutParams(params1);

    RelativeLayout.LayoutParams params2 = new RelativeLayout.LayoutParams(
         RelativeLayout.LayoutParams.MATCH_PARENT,
         RelativeLayout.LayoutParams.WRAP_CONTENT);
    params2.addRule(RelativeLayout.BELOW, i);

    EditText field = new EditText(this);
    field.setLayoutParams(params2);
    field.setId(fields.size()+i);

    mRlayout.addView(header);
    mRlayout.addView(field);
}