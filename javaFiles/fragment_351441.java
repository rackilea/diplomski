public void SelectedItemMethod(String item){
    if (item.equals("Sangat Rendah")) {
            untung1.setVisibility(View.VISIBLE);
            untung2.setVisibility(View.GONE);
            untung3.setVisibility(View.GONE);
            // And remove this! This will throw an error.
            // untungx = untung1.getSelectedItem().toString();
    } else if (item.equals("Rendah")){
    .../...