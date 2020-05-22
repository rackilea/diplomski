protected void onActivityResult(int requestCode, int resultCode, Intent data) {

  if (requestCode == MY_REQUEST) {

     if(resultCode == RESULT_OK){      
          nextQuestion();          
     }
     if (resultCode == RESULT_CANCELED) {    
         //Write your code if there's no result
     }
  }
}