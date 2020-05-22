public void lockPage(){    
        fuelProgressBar = (ProgressBar)findViewById(R.id.fuelBar); 
        //you have to find your Button before you use it.
        engB = (Button) findViewById(R.id.engB);                        
        lockB = (Button)findViewById(R.id.lockB);                                 
        lockB.setOnClickListener(new View.OnClickListener(){                      
            @Override                                                             
            public void onClick(View v){                                          
                Intent lockPage = new Intent(MainActivity.this, lockDoor.class);  
                startActivity(lockPage);                                          
            }                                                                     
        });                                                                       
    }