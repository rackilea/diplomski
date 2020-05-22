class Main<O extends Observation<O,S,D>,
           S extends State<O,S,D>,
           D extends Dynamics<O,S,D>> {
  Main(S state, O observation, D dynamics) {
      dynamics.getObservationChance(state, observation);
   }
}