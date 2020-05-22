public static final int BOATS_ARR_INDEX = 0;
public static final int CARS_ARR_INDEX = 1;

Vehicle[][] vehicleArrs = new Vehicle[2][];
vehicleArrs[BOATS_ARR_INDEX] = boatsArrayGeneratingMethod();
vehicleArrs[CARS_ARR_INDEX] = carsArrayGeneratingMethod();

for (Vehicle[] vehicleArr : vehicleArrs){
    // do whatever you want to do for all Vehicle objects here, iterating through vehicleArr
}

Boat[] boats = vehicleArrs[BOATS_ARR_INDEX];
//do you original code from the question here