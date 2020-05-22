Intent i= new Intent("com.example.secondActivity");
 i.putExtra("key",mystring);
 // for explicit intents 
 // Intent i= new Intent(ActivityName.this,SecondActivity.class);    
 // parameter 1 is the key
 // parameter 2 is the value 
 // your value
 startActivity(i);