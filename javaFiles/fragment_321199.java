Map<String,Double> deviceVoltages = new HashMap<String,Double>(); 
deviceVoltages.put("liquifier", 8.4);
deviceVoltages.put("reflarbulator", 900.0);
deviceVoltages.put("liquifier", 13.3); // replaces previous 8.4
System.out.println(deviceVoltages.get("liquifier")); 
deviceVoltages.remove("reflarbulator");