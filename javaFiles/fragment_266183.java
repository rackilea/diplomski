public void functionName(View v)
{
      Button btn = (Button)v;  // v is the Button that was clicked so cast it to a Button
      String buttonText = btn.getText().toString();  // and get its text here
      Intent intent = new Intent(MainActivity.this, activity2.class);  
      intent.putExtra("button1", buttonText);   // then send it on its way
      startActivity(intent);
}