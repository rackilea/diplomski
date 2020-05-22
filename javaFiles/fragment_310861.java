class Foo{
  private int arr[];
  public int[] getArr(){
    return this.arr;
  }
}
//from other class now

new Foo().getArr();