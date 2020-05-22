import java.util.Properties;                                                                                                  
import javax.mail.Session;                                                                                                       
import javax.mail.Authenticator;                                                                                                 
import javax.mail.PasswordAuthentication;                                                                                        
import javax.mail.Message;                                                                                          
import javax.mail.internet.MimeMessage;                                                                                          
import javax.mail.internet.InternetAddress;                                                                                      
import javax.mail.Transport;

public int RegisterDoc(Doctor user) {
        try {


                Class.forName("com.mysql.jdbc.Driver");
             con  = DriverManager.getConnection("jdbc:mysql://localhost:3306/babycare","root","");
            PreparedStatement sql = con.prepareStatement("INSERT INTO doctor(name,email,password,licno,active) VALUES(?,?,?,?,?)");
            sql.setString(1, user.Username);
            sql.setString(2, user.Email);
            sql.setString(3, user.Password);
            sql.setString(4, user.LicenceNo);
            sql.setBoolean(5, user.active);

            sql.execute();
            ResultSet rs = sql.getGeneratedKeys();
int generatedKey = 0;
if (rs.next()) {
    generatedKey = rs.getInt(1);
}
//System.out.println("Inserted record's ID: " + generatedKey);
            String smtpServer = "your smtp server";                                                                                                                   
String smtpPort = "your smtp port";                                                                                                                     
final String authAddress = "sender mail id";
final String authPassword = "password of the sender mail id";
String message = null;
String send = "send";                                                                                                 
String siteName="local";                                                                                                    
siteName=siteName.replaceAll("www.","");                                                                                                    
if(send!=null){
        smtpServer = "your smtp server"; // Enter SMTP ADDRESS
        smtpPort = "your smtp port";     //Enter SMTP PORT
        subject = "New User Registration" ;//Subject       
        email = "recepient mail id";   //Recepient Address

        message = "\n Dear: "+user.Username+" Click on this URL for Activation http://localhost:8080/ActivateDoc?id="+ generatedKey; 

        //request.getParameter("message");  //Mail Body     

                Properties props = new Properties();   
                props.put("mail.smtp.host", smtpServer);
                props.put("mail.smtp.port", smtpPort);   
            props.put("mail.smtp.auth", "true");         

            // create some properties and get the default Session
            Session sessionMail = Session.getInstance(props, new Authenticator() {
                 public PasswordAuthentication getPasswordAuthentication() {     
                         return new PasswordAuthentication(authAddress, authPassword);
                 }                                                                   
                });                                                                  

            sessionMail.setDebug(true);
            // create a message
            Message msg = new MimeMessage(sessionMail);
            // set the from and to address
            InternetAddress addressFrom = new InternetAddress(authAddress);
            msg.setFrom(addressFrom);
            InternetAddress[] addressTo = new InternetAddress[1];
            addressTo[0] = new InternetAddress(email);
            msg.setRecipients(Message.RecipientType.TO, addressTo);
            // Optional : You can also set your custom headers in the Email if you Want
            msg.addHeader("site", siteName);
            // Setting the Subject and Content Type
            msg.setSubject(subject);
            msg.setContent(message, "text/html");
            Transport.send(msg);

              return 1;
}

        } catch (SQLException ex) {
            Logger.getLogger(DbManager.class.getName()).log(Level.SEVERE, "ex happened !!!", ex);
            return 0;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DbManager.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }catch(Exception ex){
           Logger.getLogger(DbManager.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
           return 0;
        }finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(DbManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return 0;
    }