class AList<T extends A> {
  private AList() {...} // users outside the class can't invoke the constructor

  public static AList<B> createBList() {
    return new AList<B>();
  }

  public static AList<C> createCList() {
    return new AList<C>();
  }
}