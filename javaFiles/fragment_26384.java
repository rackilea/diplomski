public void update(float dt) {

       if(State == 1){
           stateTime += dt;
           if (currentAnimation.isAnimationFinished(stateTime)){
               currentAnimation = runAnimation;
               State = 0 ;
           }
       }...