public class MyClass{
    public enum State{
        STATE1 (0b1),
        STATE2(0b10),
        STATE3(0b100);

      public final int value;
      State(int value){
        this.value = value;
      }
    }

   public void setState(State stateType, boolean state){
    if(state){
        this.state |= stateType.value;
    }else{
        this.state &= ~stateType.value;
    }
  }
}