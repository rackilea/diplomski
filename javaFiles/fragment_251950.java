for (Iterator<Car> it = cars.iterator(); it.hasNext();){
     Car eachcar = it.next();
     if (eachcar.equals(selectedCar)){
        it.remove();
     }
 }