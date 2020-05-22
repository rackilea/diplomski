JSONObject obj = new JSONObject();
 obj.put("name", "JEAN-LUC PALMYRE");
 obj.put("srn", "120299364");

 JSONObject objEcc = new JSONObject();
 objEcc.put("a",a);
 objEcc.put("b",b);
 objEcc.put("k",k);
 objEcc.put("order",order);

 obj.put("ecc",objEcc);