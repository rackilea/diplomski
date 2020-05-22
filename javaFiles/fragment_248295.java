mySwitch = (SwitchCompat) rowView.findViewById(R.id.newswitch); 
mySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { 

    @Override 
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) { 
    <your_activity_name>.isChecked(isChecked); 
    } 
});