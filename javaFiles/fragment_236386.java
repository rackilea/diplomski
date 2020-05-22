String[] values = { "03.0", "FLORIDA", "FLORIDA", "05231.0", "01.0", "01.0",   "19102012130639", null, null };
   ps = conn.prepareStatement(query);
   int i = 1;
   foreach(String par : values) {
      ps.setObject(i, par);
      i++;
   }
   ps.execute();