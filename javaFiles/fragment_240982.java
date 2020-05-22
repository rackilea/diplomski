String carModel[] = {"A", "B", "C"}; //Names of cars
    int costPerDay[] = {100, 75, 250}; //Rental cost per day
    for(int x = 0; x < costPerDay.length-1; x++){ //Sort the Cost Per Day Array in descending order using bubble sort 
    for(int j = x + 1; j < costPerDay.length; j++){
    if(costPerDay[x] < costPerDay[j]){
    int t = costPerDay[x];
    String s = carModel[x];
    costPerDay[x] = costPerDay[j];
    costPerDay[j] = t;
    carModel[x] = carModel[j];
    carModel[j] = s;
    }
    }
    }
for(int x = 0; x < carModel.length; x++){
 System.out.println(carModel[i]);
}