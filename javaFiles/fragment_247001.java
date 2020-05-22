public interface Observation {
    ...
}

public interface State {
}

public interface Dynamics<S extends State,
                          O extends Observation> {
  getObservationChance(S state, O observation);
}

enum SpecialObservation implements Observation {
  FREE, WALL, etc.
}

class SpecialState implements State {
}


class SpecialDynamics implements Dynamics<SpecialState, SpecialObservation> {
   getObservationChance(SpecialState state, SpecialObservation observation) {
       // state should be SpecialState, observation should be SpecialObservation!
   }
}

class Main<S extends State, O extends Observation> {
  Main(S state, O observation, Dynamics<S, O> dynamics) {
      dynamics.getObservationChance(state, observation);
   }
}