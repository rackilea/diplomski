Program a;
Program b;

    a.run();
    while(a.isAlive()){
       if( /*we need to run program b*/){
         b.run();
         break;
       }

    }