DBObject one = cur.next();  

if (one.get("photos") == null)
  one.put("photos", new Object[0]);

return JSON.serialize(one);