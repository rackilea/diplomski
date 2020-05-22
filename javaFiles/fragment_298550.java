abstract class Airplane<M extends Measurable>{
    public abstract Airplane addAMeasurableThing(M m, int position);
}

class PassengerAirplane extends Airplane<People>{
    @Override
    public Airplane addAMeasurableThing(People p, int position{ ... }
}