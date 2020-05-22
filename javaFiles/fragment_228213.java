class C {
  int a = 11;

  {
    // Local variable hiding a field. No problem.
    double a = 0.2;
  }
}