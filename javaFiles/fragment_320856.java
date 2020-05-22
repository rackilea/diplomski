public String citiesNorthOf(String cityName){
String allCitiesNorthOf = "";// must be initialized

Point referenceCityCenter = null;

for(int i=0; this._cities[i] != null ; i++)
{
    if (this._cities[i].getCityName() == cityName)
    {
        referenceCityCenter = new Point(this._cities[i].getCityCenter());
    }
}

for(int i=0; this._cities[i] != null ; i++)//we don't need to exclude the comparable city itself because it will give a false
{
    if (referenceCityCenter !- null && this._cities[i].getCityCenter().isAbove(referenceCityCenter)) 
    {
        allCitiesNorthOf = allCitiesNorthOf.concat(this._cities[i].toString()+"\n\n");
    }
}
}