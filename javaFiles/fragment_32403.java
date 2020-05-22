public static void main(String[] args) {
    ApplicationContext context = AnnotationConfigApplicationContext("se.hsr.web")
    ContactDAO cd = (ContactDAO)context.getBean("contactDAOImpl");
    Contact contact = new Contact();
    contact.setFirstname("Zorro");
    cd.addContact(contact);
}