@Controller
public class OfficerController {
    @Inject
    private OfficerRegistrationValidation officerRegistrationValidation;

    @Inject
    private OfficerUpdateValidation officerUpdateValidation;