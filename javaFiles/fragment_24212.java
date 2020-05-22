private class MyOnClickListener implements OnLongClickListener{
    @Override
    public void onLongClick(View v){
       id=v.getId();
       switch(id){
         case R.id.item1:
            //your item1 code
         case R.id.item2:
           //your item 2 code
       }
    }
}