public class Dispatcher {
    void dispatch(FooCriterion foo) { .. }
    void dispatch(BarCriterion bar) { .. }
}

class FooCriterion implements Criterion {
   void visit(Dispatcher d) {
      d.dispatch(this);
   }
}

Dispatcher d = new Dispatcher();
for (Criterion c : criteria) {
   c.visit(d);
}