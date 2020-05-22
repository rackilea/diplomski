public class Main implements MyInterface {

  public static final void main(String args []) {
    MyInterface m = new Main();
//              ^1

    m.aMethod();
//  ^ Declarations will bring you to 1, the declaration of the variable (m)
//    Type Declaration will bring you to 2, the declaration of the type of the variable (MyInterface)
    m.aMethod();
//       ^ Declaration will bring you to 3, the declaration of the method in the type (MyInterface) of the variable
//         Implementation(s) will bring you to 4, the declaration of the method implementing the interface method
  }

  public void aMethod() {
//            ^4
  }
}