class Foo
{
     Foo()
     {
          Car car = new Car();
          string brand = car.brand; // <-- will not compile; 
                                    // should use car.getBrand()
     }
}