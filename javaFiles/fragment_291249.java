class ClassWithInProperties {
  int a, b;

  public int getA() {
    return a;
  }
  public void setA(int a) {
    this.a = a;
  }
  public int getB() {
    return b;
  }
  public void setB(int b) {
    this.b = b;
  }
  @Override
  public String toString() {
    return "a="+a+", b="+b;
  }
}

ClassWithInProperties obj=new ClassWithInProperties();
increment(obj::getA, obj::setA);
increment(obj::getA, obj::setA);
increment(obj::getB, obj::setB);
System.out.println(obj);