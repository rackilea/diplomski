public void setupRangeAxis(NumberAxis rangeAxis) {
  final TickUnits standardUnits = new TickUnits();
  standardUnits.add(new CustomTickUnit(1));
  standardUnits.add(new CustomTickUnit(10));
  standardUnits.add(new CustomTickUnit(100));
  standardUnits.add(new CustomTickUnit(1000)); // Kilo
  standardUnits.add(new CustomTickUnit(10000));
  standardUnits.add(new CustomTickUnit(100000));
  standardUnits.add(new CustomTickUnit(1000000)); // Mega
  standardUnits.add(new CustomTickUnit(10000000));
  standardUnits.add(new CustomTickUnit(100000000));
  standardUnits.add(new CustomTickUnit(1000000000)); // Giga
  standardUnits.add(new CustomTickUnit(10000000000L));
  standardUnits.add(new CustomTickUnit(100000000000L));
  standardUnits.add(new CustomTickUnit(1000000000000L)); // Tera
  standardUnits.add(new CustomTickUnit(10000000000000L));
  standardUnits.add(new CustomTickUnit(100000000000000L));
  standardUnits.add(new CustomTickUnit(1000000000000000L)); // Peta
  standardUnits.add(new CustomTickUnit(10000000000000000L));
  standardUnits.add(new CustomTickUnit(100000000000000000L));
  standardUnits.add(new CustomTickUnit(1000000000000000000L)); // Exa
  rangeAxis.setStandardTickUnits(standardUnits);
}