public interface Observation<O extends Observation<O, S, D>,
                             S extends State<O,S,D>,
                             D extends Dynamics<O,S,D>>
{
    ...
}

public interface State<O extends Observation<O,S,D>,
                       S extends State<O,S,D>,
                       D extends Dynamics<O,S,D>> {
}

public interface Dynamics<O extends Observation<O,S,D>,
                          S extends State<O,S,D>,
                          D extends Dynamics<O,S,D>> {
  getObservationChance(S state, O observation);
}