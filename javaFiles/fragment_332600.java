class Drill extends Tool {
    String model;
    int rpm;    

      Drill (double weight, int price, String model, int rpm) {
        super(weight,price); 

        this.model = model;
        this.rpm = rpm;
      }

      public void printInfo() {
        System.out.println("Weight: " + ReturnWeight());
        System.out.println("Price: " + ReturnPrice());
        System.out.println("Model: " + model);
        System.out.println("Revolution speed: " + rpm); 
      }
    }