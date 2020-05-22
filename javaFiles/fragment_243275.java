if  ( Intersector . overlaps ( Object . getBoundingCircle (), myWorld . getGround ()) || (deltaYourExc <= deltaYourTime && deltaYourExc != -1))  { 
        batcher . draw ( DownpAni . getKeyFrame ( runTime ),  Object . getX (), 
                Object . getY (),  Object . getWidth (),  Object . getHeight ()); 

    //delta is delta in render
    deltaYourExc += delta;
    if(deltaYourExc >= deltaYourTime){
    deltaYourExc = -1f
    }

    }else{ 
        batcher . draw ( JumpAni . getKeyFrame ( runTime ),  Object . getX (), 
                Object . getY (),  Object . getWidth (),  Object . getHeight ()); 
    }