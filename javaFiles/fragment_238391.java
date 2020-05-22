Test2() {
  A()
    B() {
      B::x = 3
      B::x += 2
      System.out.print("-x" + x + "\n"); // print -x5
      B::x++ // B::x is now 6
    }

    A::x = 2

    System.out.print("-x" + calculate(2)+"\n")
    A::calculate(2) {
        return(calculate()+2);
        Test2::calculate() {
            return A::x + 6;     // A::x is 2 here, so returns 8
        }
    } // returns calculate()+2, so returns 10
  }

  A::x += 3
}