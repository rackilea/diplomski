class Foo{
  private String bar;
  public Object clone(){
    Foo f=new Foo();
    f.setBar(this.bar);
    //filling and copy the f attributes
    guys.add(f);
  }
   ///
   private final static List<Foo> guys=new ArrayList<>();
   ///
}