private static int globalID = 0;
private int ID;
public obj()
{
   globalID++;
   this.ID = globalID;
}