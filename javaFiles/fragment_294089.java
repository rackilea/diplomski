//in onCreate declare some buttons
Button bt1 = (Button) findViewById(R.id.*button1_id*);
bt1.setOnClickListener(new clsOnClickListener());
Button bt2 = (Button) findViewById(R.id.*button2_id*);
bt2.setOnClickListener(new clsOnClickListener());

//You can create a class that implements OnClickListener
private class clsOnClickListener implements View.OnClickListener{
public void onClick(View v){
     if (v.getId()==R.id.button1_id{
          //do what you want
     }
     else if (v.getId()==R.id.button2_id){
         //do something else
     }
 }
}