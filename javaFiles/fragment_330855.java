spinner1.setOnItemSelected(new OnItemSelected()
{
    @Override
    public void onItemSelected(AdapterView<?> parent, View v, int position, 
                                    long id) 
    {
         TextView tv = (TextView)v;   // cast the View to a TextView
         if ("Canada".equals(tv.getText().toString())
         {
            addItemsOnSpinner2();   
         }
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {

    }
});