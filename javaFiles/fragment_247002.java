class Main<S extends State, O extends Observation> {

  public O[] getAllObservations(Class<O> oClass) {
     return oClass.getEnumConstants();
  }

  Main(S state, Dynamics<S, O> dynamics, Class<O> observationClass) {
      O[] observations = getAllObservations(observationClass);
      for(O o : observations) {
         dynamics.getObservationChance(state, observation);
      }
   }
}