Vehicle veh1 = new Vehicle();
veh1.setId(1);
veh1.setModel("Veh_mod");
veh1.setName("Veh_Name");

Vehicle veh2 = new Vehicle();
veh2.setId(1);
veh2.setModel("Veh_mod");
veh2.setName("Veh_Name");

session1.save(veh1);
session2.save(veh2); // try changing this to session2.saveOrUpdate()