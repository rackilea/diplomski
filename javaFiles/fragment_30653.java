jbtFlash.addActionListener( 
        new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) { 
                Runnable r = new Runnable(){
                       @Override
                       public void run(){
                            while(/* user stops / toggleButton state*/ true)
                            {
                                 swapColors(); // some method using static boolean
                                 try{
                                    Thread.sleep(500);
                                 }catch(Exception e){}
                            }

                       }



            }; 
            Thread t = new Thread(r);
            t.start();
            }});