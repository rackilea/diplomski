final LinearLayout linl = (LinearLayout) view.findViewById(R.id.linear_layout_tags);
linl.addView(nTv);

nTv.setOnClickListener(new View.OnClickListener() {         
    public void onClick(View v) {
        EditText et = (EditText) linl.findViewById(R.id.edittext_tags);
        TextView t = ((TextView)v);
        et.setText(t.getText().toString());
        linl.removeView(v);
    }