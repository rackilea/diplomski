public void doSomething(Quad sprite){
    //Do work here regardless of which object was passed in
    move(object);

    if(sprite instanceof Enemy) {
       //Do enemy specific stuff here
       ((Enemy) sprite).doEnemyStuff();
    }
 }