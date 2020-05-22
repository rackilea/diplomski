String cursorString = cursor.toWebSafeString();
// Send cursor around as string


// Query q = the same query that produced the cursor;
Cursor cursor = Cursor.fromWebSafeString(cursorString);
Map<String, Object> extensionMap = new HashMap<String, Object>();
extensionMap.put(JDOCursorHelper.CURSOR_EXTENSION, cursor);
q.setExtensions(extensionMap);
q.setRange(0, 20); //note, the same range; 
//the query should cover everything you expect to load.
q.execute();