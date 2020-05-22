public class UserRegistrationValidator implements Validator {
    public boolean isValid(Properties formProperties) {
        boolean isValid = false;
        // Required fields...
        if (formProperties.containsKey("firstName") && formProperties.containsKey("lastName") && formProperties.containsKey("email")) {
            // Further processing, valid each required field...
        }
        if (isValid) {
            // Process optional parameters
        }
        return isValid;
    }
}