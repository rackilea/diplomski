int user = 0; //class instance variable
public void onCreate(Bundle icicle)
{

  //...
  try{
    user = Integer.parseInt(dniText.getText().toString()); //no "int", just user
  }
  catch (NumberFormatException e)
  {
  }
}