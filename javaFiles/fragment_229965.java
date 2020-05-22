@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface MyAnnotation {
}

public class Vehicle {

    private String vehicle_name;

    @MyAnnotation
    private String vehicle_model;
    //getters and setters

    public static void main(String[] args) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        objectMapper.setAnnotationIntrospector(new JacksonAnnotationIntrospector() {

            @Override
            public boolean hasIgnoreMarker(AnnotatedMember m) {

                if (!System.getenv("var").equals("true")) {
                    return false;
                }
                if(_findAnnotation(m, MyAnnotation.class) != null){
                    return true;
                } else {
                    return false;
                }
            });

        Vehicle vehicle = new Vehicle();
        vehicle.setVehicle_model("vehicle_model_value");
        vehicle.setVehicle_name("vehicle_name_value");

        String value = objectMapper.writeValueAsString(vehicle);
        System.out.println(value);
    }
}