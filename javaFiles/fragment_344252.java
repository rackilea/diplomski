public void addCar(Car c) throws Exception{
    if(allCars.contains(c))
        throw new Exception("this user has already this car");
    if(c.getOwner()!=this && c.getOwner()!=null)
        throw new Exception("this car belongs to other owner");

    c.setOwner(this);
    allCars.add(c);
}