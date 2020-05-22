public class YourActivity implements View.OnClickListener {

   //...on create
   button1.setOnClickListener(this);
   button2.setOnClickListener(this);
   //..and so on
   //...
   @Override
   public void onClick(View view) {
       //You can determine which button is clicked by view.getId()    
       //Add logic here
   }
}