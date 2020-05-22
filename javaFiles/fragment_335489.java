public class VehicleValidator implements Validator {

    public boolean supports(Class clazz) {
        return VehicleDto.class.equals(clazz);
    }

    public void validate(Object obj, Errors errors) {

        VehicleDto dto = (VehicleDto) obj;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "type",
                                    "error.message.for.type.field");

        if (null != dto.getType()
              && null != dto.getCar()
              && null != dto.getBike()) {
            switch(dto.getType()) {
                case "car":
                    errors.rejectValue("bike", "error.message.for.bike.field");
                    break;
                case "bike":
                    errors.rejectValue("car", "error.message.for.car.field");
                    break;
            }
        }
    }
}