void change3(Car c) //receives the reference to the object you pass;
{
    c = new Car(888,"Audi"); //creates a new Car object and assigns reference to that **new object** to the variable c.
    c.price=80; //here, you're changing the price/name fields of different object.
    c.name="xxx";
}