public void main()
{
  Builder<? extends Vehicle> builder;
  Vehicle vehicle;

  builder = new CarBuilder();
  vehicle = createAndUpdateHelper(builder, "my original Car spec", "my modified Car spec");

  builder = new BusBuilder();
  vehicle = createAndUpdateHelper(builder, "my original Bus spec", "my modified Bus spec");
}

private static <V extends Vehicle> V createAndUpdateHelper(Builder<V> builder, String s1, String s2)
{
  V v = builder.createVehicle(s1);
  builder.updateVehicle(s2, v);
  return v;
}