class A{

  private CommonProcess commonProcess;

  public int[] method1(){
   ...
   int res = commonProcess.method(...);
   ...
   return intArray;
  }

  public int method2(){
   ....
   commonProcess.method(...);
   ...
   return intA;
  }
}