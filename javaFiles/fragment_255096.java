public class Generation <T extends MathFunc> {
  private final ArrayList<T> pop = new ArrayList<>();
  private final ArrayList<T> nextpop = new ArrayList<>();
  private final ArrayList<T> Crossover = new ArrayList<>();

  Generation(T tp)  {
    for(int i = 0; i < PopSize; i++) {
        pop.add(tp);
    }
  }
}