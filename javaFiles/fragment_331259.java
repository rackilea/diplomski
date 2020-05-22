class Context {  
    State state;                  

    public Context(){  
         state = STATE1;//Starting state
    }  

    void someMethod() { 
            state.someMethod(this);  //Which is it?State1 or state 2???
    }  

}

public interface States {  
    public static final State STATE1 = new State1();  
    public static final State STATE2 = new State2();   
    //more states here

}  

class State1 implements State {
     @Override         
      public void someMethod(Context ctx) {            
      System.out.println("StateA.SomeMethod");  
      ctx.setState(STATE2); //advance to next state        
  }
}

class State2 implements State {
    @Override         
    public void someMethod(Context ctx) {            
    System.out.println("StateB.SomeMethod");  
    ctx.setState(STATE1); //advance to next state (back to state 1)          
    }
}