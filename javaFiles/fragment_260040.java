public class Car {   

    private String make;
    private String model;

    public void setMake (String str1) {

        make = str1;

    }

    public void setModel (String str2) {

        model = str2;

    }

    @Override
    public String toString() {
         return "Make  :"+ make + "  Model :" + model;
    }

}