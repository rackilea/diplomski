toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        Toast.makeText(buttonView.getContext(), "test", Toast.LENGTH_LONG).show();
    }
});