private List<Truck> fleetList;

public Fleet(String businessName){
    this.businessName = businessName;
    this.fleetList = new ArrayList<Truck>();
}

public List<Truck> getFleetList()
{
    return this.fleetList;
}