class Move {

   int from, to;

   @Override
   public int hashCode() {
      return from + (to * 100);
   }

   @Override
   public boolean equals(Object o) {
      return (o instanceof Move
              && ((Move) o).from == from
              && ((Move) o).to == to);
   }
}

class History extends Move implements Comparable<History> {

   int frequency;

   public History(Move m) {
      from = m.from;
      to = m.to;
      frequency = 1;
   }

   public void increment() {
      frequency += 1;
   }

   public int compareTo(History h) {
      // to be able to sort it in a TreeSet descending on frequency
      // note that it is not resorted if you change frequencies, so 
      // build the set, and then convert it to a TreeSet afterwards.
      return (frequency == h.frequency) ? 1 : (h.frequency - frequency);
   }
}