// incomplete code example

// WORKAROUND CODE
Map<ITable, ITable> oldNewMap = new HashMap<ITable, ITable>();

for(Object table : db.getTables()) {

  ITable t = (ITable)((ITable)table).clone(true);
  System.out.println(t.getName());

  // modifying t, bag is an existing instance of class PropertyBag
  t.getConnectionInfo().setAttributes(bag);

  // WORKAROUND CODE
  oldNewMap.put((ITable)table, t);

}

// WORKAROUND CODE
for (Entry<ITable, ITable> e : oldNewMap.entrySet()) {
  dc.setTableLocation(e.getKey(), e.getValue());
}