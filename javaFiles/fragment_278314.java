while (rs.next()) {
-                String id = rs.getString(FIELDS[0]);
+                Integer id = rs.getInt(FIELDS[0]);
                 String name = rs.getString(FIELDS[1]);
-                Data team = new Data(Integer.parseInt(id.trim()), name);
+                Data team = new Data(id, name);
                 list.put(id, team);