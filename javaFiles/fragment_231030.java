public void onCheckboxClicked(View view) {
    // Is the view now checked?
    boolean checked = ((CheckBox) view).isChecked();

   if (checked)
   { 
       cost = 6.99;
   }
   else
   {
      cost =4.99;
   }

}