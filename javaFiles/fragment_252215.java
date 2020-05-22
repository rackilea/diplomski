holder.name.setOnClickListener( new View.OnClickListener() {
    public void onClick(View v) {
        CheckBox cb = (CheckBox) v ;
        TypePoi country = (TypePoi) cb.getTag();
        Toast.makeText(getApplicationContext(),
                "Clicked on : " + cb.getText(),
                Toast.LENGTH_LONG).show();
        country.setSelected(cb.isChecked()); // throws NullPointerException!
    }
});