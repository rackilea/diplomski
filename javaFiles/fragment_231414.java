LayoutInflater linf = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
linf = LayoutInflater.from(YourActivity.this);

//Linear Layout on you want to add inflated View
 LinearLayout tbl_layout=(LinearLayout)findViewById(R.id.Layoutid);

 for (int i = 0; i < arrayList.size(); i++) {

       View v = linf.inflate(R.layout.YourLinearLayout, null);//Pass your lineraLayout

      ((TextView) v.findViewById(R.id.xxxx)).setText("textS");

        tbl_layout.addView(v);
    }