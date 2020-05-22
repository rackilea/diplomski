private ArrayList<Fleet> fleetCollection;    
...   
for (Fleet fleet : this.fleetCollection)
{
    for (Truck truck : fleet.getFleetList())
    {
         //Do something with your truck here
    }
}