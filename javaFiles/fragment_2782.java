Map<String, Class<?>>  menuMap = new HashMap<>();
  menuMap.put("Car", Car.class);
  menuMap.put("MotorCycle", MotorCycle.class);

  Class<?> lookup = menuMap.get("Car");

  for (Vehicle v : inventory.get(lookup)) {
     System.out.println(v.toString()); 
  }