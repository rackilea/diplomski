@Component
public class PatientFormConverter implements DtoToEntityConverter<PatientForm, Patient> {

    public Patient getEntity(PatientForm form) {
        // Conversion rules and stuff...
    }
}