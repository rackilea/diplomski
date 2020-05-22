button.setOnClickListener(new View.OnClickListener(){ 
  @Override
  public void onClick(View view){ 
    if(textView.getText().toString()!=null) {
    value = textView.getText().toString();
    datalist.add(value);
    }
  }
});