public final class BeanFactory() {

    private static ClassPathXmlApplicationContext context;

    private static ClassPathXmlApplicationContext getContext() {
        if (context== null) {
            context = new ClassPathXmlApplicationContext("applicationContext.xml");
        }
        return context;
    }

    public static OfficerRegistrationValidation getOfficerRegistrationValidation() {
        return (OfficerRegistrationValidation) getContext().getBean("officerRegistrationValidation");
    }
}