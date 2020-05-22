for (ScheduleAttr s : schedule) {
  Object[] o = new Object[5];
  o[0] = s.getX();
  o[1] = s.getY();
  o[2] = s.getZ();
  o[3] = s.getA();
  o[4] = s.getB();
  model.addRow(o);
}