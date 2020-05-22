public class Huracan implements Car {           
    private final String CAR_TYPE;
    private final URL COMPANY_URL;

    @BindingAnnotation
    @Retention(RUNTIME)
    public @interface HuracanCar {}

    public Huracan( @HuracanCar String carType, 
                    @HuracanCar URL companyUrl ) {
        this.CAR_TYPE = carType;
        this.COMPANY_URL = companyUrl;
    }
}