Hashtable table = new Hashtable();
table.put(table, table);
System.out.println("table = " + table);
table.put("abc", "def");
System.out.println("table = " + table);
table.remove(table); //does not work as expected !!!
System.out.println("table = " + table);