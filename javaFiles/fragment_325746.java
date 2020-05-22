public void doSomething(Quad sprite){
    //Do work here regardless of which object was passed in
    move(object);

    if(sprite instanceof Bird) {
       //Do bird specific stuff here
    }
    else if {sprite instanceof Snail}{
       //Do snail stuff here
    }
 }