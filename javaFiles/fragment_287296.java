LinearLayout layout = (LinearLayout)findViewById(R.id.layout_cbx);
        for(String item : items){
            CheckBox cbx = new CheckBox(this);
            cbx.setText(item);
            layout.addView(cbx);
        }