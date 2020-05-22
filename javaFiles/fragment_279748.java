if(ed1.getText().toString().equals("admin") && 
          ed2.getText().toString().equals("admin")) {
                Toast.makeText(getApplicationContext(), "Redirecting...",Toast.LENGTH_SHORT).show();

       Intent intent=new Intent(MainActivity.this,LoginActivity.class); // redirecting to LoginActivity.
       startActivity(intent);
  }