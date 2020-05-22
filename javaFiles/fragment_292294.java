Foo<Float> foo = new Foo<>(new Foo.NumberFactory<Float>() {
  @Override
    public Float createByDoubleValue(double value) {
      return new Float(value);
    }
});