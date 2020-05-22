SuperMap<String, String> sm = new SuperMap<String, String>();
sm.put("Elvis", "Presley");

sm.addAlias("Priscilla", "Elvis");
System.out.println(sm.get("Elvis"));
System.out.println(sm.get("Priscilla"));

sm.put("Elvis", "Costello");
System.out.println(sm.get("Elvis"));
System.out.println(sm.get("Priscilla"));