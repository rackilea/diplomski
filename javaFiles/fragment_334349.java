try {
            if (result.getString("message").equals("Successfully logged in"))  {
                Toast.makeText(getApplicationContext(),result.getString("message"),Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(), ActivitySecond.class);
                startActivity(intent);
            }
            else {
                Toast.makeText(getApplicationContext(), "Unable to retrieve any data from server", Toast.LENGTH_LONG).show();
            }