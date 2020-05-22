public class Context<T> {
   private Stuff<T> stuff;
   public setStrategy(Stuff<T> stuff) { this.stuff = stuff; }

   public T doStuff() { // ARGH!
      return stuff.getStuff()
   }
}