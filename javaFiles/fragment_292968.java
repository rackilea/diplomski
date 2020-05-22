Vehicle vehicle = VehiclePeer.doSelectFirst(c);
if (vehicleName != null && !vehicleName.equals("")) {                    
  c.clear();
  c.add(TariffPeer.VEHICLE_ID,vehicle.getId());
  Set<Tariff> tarrifSet = TariffPeer.doSelectAll(vehicle.getId());
  for (Tariff tariff: tarrifSet) { 
    if (tariff !=null && !tariff.equals("")) {       
      c.add(TariffParamsPeer.TARIFF_ID, tariff.getId());
      TariffPeer.doDelete(tariff);
    }
  }
}