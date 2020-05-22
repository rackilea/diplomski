public class SomeOtherClass {

    public static void main(String[] args) {
         TadPole tadpole = new TadPole();
         Frog frog = new Frog();
         int revealedValue = tadpole.revealFieldValueOfParent(frog);
         // print revealedValue
    }
}