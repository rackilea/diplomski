public class ValuePair {
    public int a;
    public int b;
}

public ValuePair takeInput(){
  ValuePair pair = new ValuePair();
  println("Enter a number: (a) and (b)\n");
  pair.a = readInt("a:");
  pair.b = readInt("b:");
  return pair;
}