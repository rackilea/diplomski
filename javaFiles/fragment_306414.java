static void makeAThree(Reference<Integer> ref)
{
   ref.set(3);
}

public static void main(String[] args)
{
  Reference<Integer> myInt = new Reference<>(4);
  makeAThree(myInt);
  System.out.println(myInt.get());
}