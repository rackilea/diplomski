// incomplete code example

for(Object table : db.getTables()) {

  ITable t = (ITable)((ITable)table).clone(true);
  System.out.println(t.getName());

  // modifying t, bag is an existing instance of class PropertyBag
  t.getConnectionInfo().setAttributes(bag);

  // dc is an existing instance of DatabaseController
  dc.setTableLocation((ITable)table, t)

}