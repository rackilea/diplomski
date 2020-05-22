int carsNumber = 10;//number of cars
Car [] cars = new Car[carsNumber];//creates empty array (10 null)
for (int i = 0; i < cars.length; i++)
{
    Car c = readCar(make,model);//creates Car somehow
    cars[i] = c;//populates current car in array, i++ command will move to next index
}