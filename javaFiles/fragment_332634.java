try {
                sender.send();
               Toast.makeText(MainActivity.this, "Mail send", Toast.LENGTH_LONG).show();
            }
            catch (Exception e) {                   

                if (e.toString().equals("java.lang.NullPointerException"))                      
                    Toast.makeText(MainActivity.this, "Mail not send: Mail settings not configured", Toast.LENGTH_LONG).show();

                else if (e.toString().equals("javax.mail.AuthenticationFailedException"))                       
                    Toast.makeText(MainActivity.this, "Mail not send: Wrong Username or Password", Toast.LENGTH_LONG).show();

                else if (e.toString().equals("Invalid Addresses"))                      
                    Toast.makeText(MainActivity.this, "Mail not send: Invalid Address(es)", Toast.LENGTH_LONG).show();

                else
                    Toast.makeText(MainActivity.this, "Mail not send", Toast.LENGTH_LONG).show();                   

                }