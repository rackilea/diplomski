Activity A :  monsterB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(), Monster.class);
             i.putExtra("url", "https://www.google.co.in/");
                //int x = 1;        
                startActivity(i);    
            }
        });

        naukrii.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(), Monster.class);
               i.putExtra("url", "https://www.naukri.com/");
                //x=2    
                startActivity(i);    
            }
        });