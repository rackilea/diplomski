public void animate(QuadBatch param) {

  // animation code here

  //if you need specific method calls you could cast the parameter here to a NewSprite
  if (param instanceof NewSprite) {
      NewSprite newSprite = (NewSprite)param;
      //do NewSprite specific stuff here
  }

}

//However, hopefully you have a method like doAnimate() on QuadBatch 
//that you have overloaded in NewSprite
//and can just call it and get object specific results

public void animate(QuadBatch param) {

  param.doAnimate();

}