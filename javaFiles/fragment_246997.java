public interface Observation<O extends Observation<O>> {
    ...
}

public interface State<O extends Observation<O>> {
}

public interface Dynamics<O extends Observation<O>> {
  getObservationChance(State<O> state, O observation);
}

enum SpecialObservation implements Observation<SpecialObservation> {
  FREE, WALL, etc.
}

class SpecialState implements State<SpecialObservation> {
}


class SpecialDynamics implements Dynamics<SpecialObservation> {
   getObservationChance(State<SpecialObservation> state, SpecialObservation observation) {
       // state should be SpecialState, observation should be SpecialObservation!
   }
}

class Main<O extends Observation> {
  Main(State<O> state, O observation, Dynamics<O> dynamics) {
      dynamics.getObservationChance(state, observation);
   }
}