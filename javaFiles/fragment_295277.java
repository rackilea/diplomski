@FacesConverter(forClass=Car.class, value="carconvertor")
public class CarConverter 
implements Converter {
    @Override
    public Object getAsObject(FacesContext arg0, UIComponent component, String stringvalue) {
        Car car = new Car(stringvalue);
        return car;
    }

    @Override
    public String getAsString(FacesContext arg0, UIComponent component, Object objectvalue) {
        Car car = (Car) objectvalue;

        if(car == null) {
            return StringUtils.EMPTY;
        }

        return car.getCarmodel();
    }
}