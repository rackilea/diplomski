enum State {
   state1, state2, state3;
}

State state = State.state1;

public boolean func() {
   while(true) {
     switch(state) {
        case state1:
            if(test()) return true;
            state = state2;
            break;
        case state2:
            if(test2()) return false;
            state = state3;
            break;
        case state3:
            if(test3()) return true;
            state = state1;
            break;
      }
   }
}