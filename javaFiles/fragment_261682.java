class MyOtherClass implements MyInterface
{
  int myMember1;
  int myMember2;
  int myMember3;
  int myInterfaceMethod(int p, int q) { myMember1 = p; myMember2 = q; myMember3 = p - q; }
  int myNonInterfaceMethod() { return myMember1; }
}
MyOtherClass myVariable3 = new MyOtherClass();