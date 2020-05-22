Set<SlowCar> slowSet = ...;

slowSet.add(new FastCar()); // Obviously ERROR, FastCar does not extend SlowCar

Set<? extends Car> carSet = slowSet; // Allowed, valid (SlowCar extends Car)

carSet.add(new FastCar());   // Error, because carSet might be
                             // and actually is a set of SlowCars