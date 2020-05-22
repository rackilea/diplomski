@Projection(name="minimal", types = {Registration.class})
public interface RegistrationProjection {

    @Value("#{target.getStudent().getUserName()}")
    String getUserName();
}