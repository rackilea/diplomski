public class MyProducers {
    @Produces
    public NonCdiClass produceNonCdiClass() {
        return new NonCdiClass();
        };
    }
  }