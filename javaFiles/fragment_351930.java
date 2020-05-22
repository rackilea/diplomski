private String SpinnerSelectedValue="";
@Override
public boolean onCreateOptionsMenu(Menu menu) {
   MenuInflater inflater = getMenuInflater();
   inflater.inflate(R.menu.menu_classviewstudents, menu);
   MenuItem item = menu.findItem(R.id.AddGrades);
   SpinnerPMF = (Spinner)item.getActionView();
   SpinnerPMF.setOnItemSelectedListener(new OnItemSelectedListener() {

     @Override
     public void onItemSelected(AdapterView<?> parentView, View selectedItemView, 
                                                         int position, long id) {
       SpinnerSelectedValue=parentView.getItemAtPosition(position).toString();
    }

  });
 return true;
}