Map<Integer, String> m = new HashMap<Integer, String>();
for (String s : str.split(",")) {
   s = s.trim();
   int keyvalstart = -1;
   for (int i = 0; i < s.length(); i++) {
      if (!Character.isDigit(i)) {
         keyvalstart = i;
         break;
      }
   }
   if (keyvalstart == -1) continue;
   String s_id    = s.substring(0, keyvalstart - 1);
   String keyvals = s.substring(keyvalstart);
   int    id      = Integer.parseInt(s_id);
   m.put(id, keyvals);
}