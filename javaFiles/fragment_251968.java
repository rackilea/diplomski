public void methodA(int... ints, int a); // doesn't compile
public void methodA(int[] ints, int a); // compiles

public void methodB(int... ints); // compiles
public void methodC(int[] ints); // compiles

methodB(1); // compiles
methodB(1,2,3,4); // compiles
methodC(1); // doesn't compile
methodC(1,2,3,4); // doesn't compile