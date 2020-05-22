Car car = mWeakReference.get();
if (car == null) {
    car = new Car();
    mWeakReference= new WeakReference<Car>(car);
} 
car.run();