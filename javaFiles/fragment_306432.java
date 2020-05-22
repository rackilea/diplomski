public void onBackPressed(){

   super.onBackPressed()

Intent intent=new Intent();  
                    intent.putExtra("isdeleted",true);  
intent.putExtra("pos",position);
                    setResult(2,intent);  
                    finish();
}