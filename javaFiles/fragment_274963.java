switch(currentState){
      case RUNNING:
        //Go.getKeyFrame(stateTimer, true);
        //Should be ...
        region = Go.getKeyFrame(stateTimer, true);
        break;
      case STANDING:
      default:
        region = Still;
        break;
    }