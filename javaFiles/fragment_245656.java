for(Gesture gesture : gestures){
  if(gesture.type() == KeyTapGesture.classType()){
    KeyTapGesture keytap = new KeyTapGesture(gesture);
    Pointable tappingPointable = keytap.pointable();
    if(tappingPointable.isFinger()){
      Finger tappingFinger = new Finger(tappingPointable);
      println("Tapper: " + tappingFinger.type());
    }
  }
}