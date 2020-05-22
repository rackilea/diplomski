public class MeasurementValidator implements ConstraintValidator<ValidMeasurementInput, MetricsDTO> {

    @Override
    public boolean isValid(MetricsDTO metricsDTO, ConstraintValidatorContext context) {
        ...
    }
}