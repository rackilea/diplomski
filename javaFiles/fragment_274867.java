ch = (CheckBox)findViewById(R.id.checkbox);              
ch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

    @Override
    public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
        if(isChecked){
            framelayout.setVisibility(View.VISIBLE);//framelayout is your layout,initially set GONE.
        }
    }
  });