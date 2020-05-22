class IntItem extends Item<Integer> {

  private Integer item;

  // Bridge method 1
  public void set(Object item) {
    set((Integer) item);
  }

  public void set(Integer item) {
    this.item = item;
  }

  //Bridge method 2
  public Object get() {
   return <Integer>get(); // pseudosyntax
  }

  public Integer get() {
   return item;
  } 
}