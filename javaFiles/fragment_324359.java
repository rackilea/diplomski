Add.setOnClickListener(new OnClickListener() {          
    public void onClick(View v) {
        String StInput= ET.getText().toString();
        if(StInput != null && StInput.length() > 0){
            ArLi.add(StInput);
            ArAd.notifyDataSetChanged();
            ET.setText("");
        }else{
           //EditText is blank
        }
    }       
});