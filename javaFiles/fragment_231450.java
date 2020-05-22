public class MailApp {
  public static void main( String[] args )
    {
        ApplicationContext context = 
             new ClassPathXmlApplicationContext("beans.xml");

        EmailNotifier emailNotifier = (EmailNotifier) context.getBean("emailNotifier");
        try {
            emailNotifier.sendMail(new InternetAddress("adminxxxx@gmail.com"),
                    new InternetAddress("recipientxxxx@gmail.com"),
                   "Email Alert!", 
                   "Hello User, This is a test email \n No response required.");
        } catch (AddressException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }    
    }