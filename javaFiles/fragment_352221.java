public class Starter {

    public static void main(String[] args) {
        User user = new User();
        user.setUserName("Name");
        user.setUserSurname("Surname");

        UserWrapper userWrapper = new UserWrapper(user);

        try {
            JAXBContext context = JAXBContext.newInstance(UserWrapper.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            m.marshal(userWrapper, System.out);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

}