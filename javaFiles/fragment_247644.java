public enum Car {
    private Carparts carparts;

    @Component
    public static class CarPartsInjector {
        @Inject
        private Carparts carparts;

        @PostConstruct
        public void construct() {
            for (Car car: EnumSet.allOf(Car.class))
               car.setCarparts(carparts);
        }

        private void setCarparts(Carparts carparts) {
            this.carparts = carparts;
        }
    //...

}