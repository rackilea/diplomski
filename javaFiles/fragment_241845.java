java.util.Date d = new java.util.Date();

Statement stmt = ....;

...

stmt.setDate(1, new java.sql.Date(d.getTime());