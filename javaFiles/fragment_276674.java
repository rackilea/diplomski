check[i].setId(100+i);
check[i].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

   @Override
   public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {

      switch(buttonView.getId()) {
        case R.id.checkbox_meat:
         // do your code here...
          break;
        case R.id.checkbox_cheese:
         // do your code here...
          break;
       // TODO: Veggie sandwich
      }

   }
});