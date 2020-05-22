public Response addVehicle(VehicleTravelBo vehicle) {
Session session = travelHibernateDao.getSessionFactory().getCurrentSession();
session.getTransaction().begin();


UserTravelDO userDO = session.get(UserTravelDO.class, vehicle.getUserid());
if(userDO == null)
{
    System.out.println("notexist");
}
else
{
   System.out.println(userDO.getId());
   VehicleTravelDO vehicleDO = ProfileDtoConverter.convertBOtoDO(vehicle);
   userDO.addVehicle(vehicleDO);
}

session.getTransaction().commit();
HashMap praf= new HashMap();
praf.put("message", "user  updated");
//System.out.println("Leavetable updated successfully");
return Response.ok(praf).build();