public class Pythagoras {
     private ValuePairSource valuePairSource;

     public Pythagoras(ValuePairSource source) {
         this.valuePairSource = source;
     }

     public double hypotenuse() {
         ValuePair pair = valuePairSource.getPair();
         return Math.sqrt(pair.a ^ 2 + pair.b ^ 2)
     }
}