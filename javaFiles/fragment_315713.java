// try this way,hope this will help you...

et2.setTag(et2.getId());
et2.setOnClickListener(new OnClickListener() {

    @Override
    public void onClick(final View v) {
      // TODO Auto-generated method stub

      Log.d("id of edit text", ""+et2.getId());
      timePicker(new OnTimeSelected(){
           public void onSelect(String time){
               ((EditText)v.getTag()).setText(time);
           }
      });
    }
});


interface OnTimeSelected{
  public void onSelect(String time);
}