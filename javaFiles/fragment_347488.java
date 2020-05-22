protected void onActivityResult(int requestCode, int resultCode, Intent data) 
{
      if (requestCode == 1 && data != null) 
      {
         Log.v("TAG", data.getStringExtra("Note"));
         if(resultCode == RESULT_OK)
         {        
             listItems.add(data.getStringExtra("Note"));
             Log.v("TAG", data.getStringExtra("Note"));
             adapter.notifyDataSetChanged();
             listView.invalidateViews();
         }
         if (resultCode == RESULT_CANCELED) 
         {   

         }
      }
}