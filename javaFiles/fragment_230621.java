public void finalSelection(View view){
    String final_fruit_selection = "";
    for(String Selection : selection){
       final_fruit_selection = final_fruit_selection + Selection + "\n";
    }
    final_text.setText(final_fruit_selection);
    selection.clear();
    final_text.setEnabled(true);

    //now clear checkboxes
    checkBox181.setChecked(false);
    checkBox182.setChecked(false);
    checkBox183.setChecked(false);
    checkBoxCM.setChecked(false);
}