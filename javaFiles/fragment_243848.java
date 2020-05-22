public class Car : Vehicle
{
   public void Accept( IVehicleFormatter v )
   {
       v.Visit (this);
   }
}

public class Truck : Vehicle
{
   public void Accept( IVehicleFormatter v )
   {
       v.Visit (this);
   }
}

public interface IVehicleFormatter
{
   public void Visit( Car c );
   public void Visit( Truck t );
}

public class VehicleXmlFormatter : IVehicleFormatter
{
}

public class VehicleSoapFormatter : IVehicleFormatter
{
}