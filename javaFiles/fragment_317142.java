if(textView5 != null)
{
      int dInt = Integer.parseInt(textView5.getText().toString());
      if(dInt <= 0)
                {
                     Toast.makeText(getApplicationContext(), "Game Over",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainActivity.this, Fifth.class));
                }
     }