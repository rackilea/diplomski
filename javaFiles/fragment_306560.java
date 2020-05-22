class MyCar implements ICar{

    private final Car car;
    public MyCar(Car car)
    {
         this.car = car;
    }

    public string getModel()
    {
          return car.model;
    }

    public void setModel(string value)
    {
          car.model = value;
    }

}