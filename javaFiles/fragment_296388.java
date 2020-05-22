public void someFunction(View v) //just use the same name as in your xml
{
    int id = v.getId();
    if (id == R.id.pb1){        
        text.append("1");
    }

    if (id == R.id.pb2){        
      text.append("2");
     // etc
}