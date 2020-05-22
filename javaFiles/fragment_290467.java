protected void onActivityResult(int requestCode,int resultCode,Intent data) // Intent data is the intent that includes the data of your AddTimeActivity
{
  if(requestCode==TIME_ENTRY_REQUEST_CODE)
  {
    if(resultCode==RESULT_OK)
    {   
      Bundle extras=data.getExtras(); // not getIntent().getExtras()
      String time=extras.getString("time");
      String notes=extras.getString("notes");
      timeTrackerAdapter.addTimeRecord(time, notes);
      timeTrackerAdapter.notifyDataSetChanged();  
    }
  }
}