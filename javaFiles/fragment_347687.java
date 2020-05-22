public class UserInputValuePairSource implements ValuePairSource {
    @Override
    public ValuePair getPair() {
         ValuePair pair = new ValuePair();
         println("Enter a number: (a) and (b)\n");
         pair.a = readInt("a:");
         pair.b = readInt("b:");
         return pair;
    }
}