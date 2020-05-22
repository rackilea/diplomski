enum SpecialObservation implements Observation<SpecialObservation, SpecialState, SpecialDynamics> {
  FREE, WALL, etc.
}

class SpecialState implements State<SpecialObservation, SpecialState, SpecialDynamics> {
}


class SpecialDynamics implements Dynamics<SpecialObservation, SpecialState, SpecialDynamics> {
   getObservationChance(SpecialObservation state, SpecialObservation observation) {
       // state should be SpecialState, observation should be SpecialObservation!
   }
}