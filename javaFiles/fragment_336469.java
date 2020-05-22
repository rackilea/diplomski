public class Term implements Comparable<Term> {
    private Character alpha;
   private int number;
   //getter and setters +Constructors as you specified
   ....
    ....
     ...
      .....
//  Now Set a criteria to sort is the Alphanumeric.
    @Override
    public int compareTo(Term prm_obj) {
        if (prm_obj.getAlpha() > this.alpha) {
            return 1;
        } else if (prm_obj.getAlpha() < this.alpha) {
            return -1;

        } else {
            return 0;
        }

    }