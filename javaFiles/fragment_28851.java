Map<String, Number> vars = new HashMap<>();
vars.put("invslot_1", 3267);

for (int i = 0; i < 44; i++) 
    if (!vars.contains("invslot_" + i))     // put only if "var" is not already "assigned"
        vars.put("invslot_" + i, i);

System.out.println(vars.get("invslot_1"));  // 3267
System.out.println(vars.get("invslot_11")); // 11