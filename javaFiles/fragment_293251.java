//.. on create
Button button1 = (Button)findViewById(R.id.button1);
Button button2 = (Button)findViewById(R.id.button2);
Button button3 = (Button)findViewById(R.id.button3);
Button button4 = (Button)findViewById(R.id.button4);
Button button5 = (Button)findViewById(R.id.button5); 

ListenerClass listener = new ListenerClass();
button1.setOnClickListener(listener);
button2.setOnClickListener(listener);
//..and so on

//Create class
public class ListenerClass implements View.OnClickListener {

     //...
     @Override
     public void onClick(View view) {
          //You can determine which button is clicked by view.getId()    
          //Add logic here
     } 
 }