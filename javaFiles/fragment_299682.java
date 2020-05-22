public class Bean implements Observable{

  // code to maintain listeners
  private List<Listener> listeners = new ArrayList<Listener>();
  public void add(Listener listener) {listeners.add(listener);}
  public void remove(Listener listener) {listeners.remove(listener);}

  // a sample field
  private int field;
  public int getField() {return field;}
  public int setField(int value) {
    field = value;
    fire("field");        
  }

  // notification code
  private void fire(String attribute) {
    for (Listener listener:listeners) {
      fieldChanged(this, attribute);
    }
  }
}