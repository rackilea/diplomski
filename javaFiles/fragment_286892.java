Query q = pm.newQuery(Person.class);
q.setRange(0, 20);

List<Person> results = (List<Person>) q.execute();
// Use the first 20 results

Cursor cursor = JDOCursorHelper.getCursor(results);