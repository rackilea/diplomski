package controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;

@WebServlet("/uploadServlet")
@MultipartConfig(maxFileSize = 16177215)

public class UploadFileController extends HttpServlet 
{
public static String user= "root";
public static String password = "x";
public static Connection getConnection() throws ClassNotFoundException{
    Connection conn=null;
    try{
        Class.forName("com.mysql.jdbc.Driver");
        conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/kps","root","X");
        System.out.println("Connected");
    }catch(SQLException e){System.err.println(e);}

    return conn;
}
@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException 
{
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();

            InputStream inputStream = null;

            Random rand = new Random();
            int  n = rand.nextInt(9999) + 1;
            String idTemp=(String.valueOf(n));


            String title=(request.getParameter("title"));
            Part filePart = request.getPart("file_uploaded");

            if (filePart != null) 
            {
                System.out.println(filePart.getName());
                System.out.println(filePart.getSize());
                System.out.println(filePart.getContentType());

                inputStream = filePart.getInputStream();
            }

            try 
            {
                Connection conn = UploadFileController.getConnection();
                //Connection conn= dbconn.Connection();

                String sql = "INSERT INTO files (id, title, file) values (?, ?, ?)";
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, idTemp);
                statement.setString(2, title);

                if (inputStream != null) 
                {
                    statement.setBinaryStream(3, inputStream, (int) filePart.getSize());
                }

                int row = statement.executeUpdate();
                if (row > 0) 
                {
                    try{
                        String host ="smtp.gmail.com" ;
                        String user = "email";
                        String pass = "password";
                        String to = "another email";
                        String from = "email";
                        String subject = "New Application Have Arrived";
                        String messageText = "Please Check Career Website";
                        boolean sessionDebug = false;

                        Properties props = System.getProperties();

                        props.put("mail.smtp.starttls.enable", "true");
                        props.put("mail.smtp.host", host);
                        props.put("mail.smtp.port", "587");
                        props.put("mail.smtp.auth", "true");
                        props.put("mail.smtp.starttls.required", "true");

                        java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
                        Session mailSession = Session.getDefaultInstance(props, null);
                        mailSession.setDebug(sessionDebug);
                        Message msg = new MimeMessage(mailSession);
                        msg.setFrom(new InternetAddress(from));
                        InternetAddress[] address = {new InternetAddress(to)}; //address of sender
                        msg.setRecipients(Message.RecipientType.TO, address); //receiver to email
                        msg.setSubject(subject); msg.setSentDate(new Date()); //message send date
                        msg.setText(messageText); //actual message

                       Transport transport=mailSession.getTransport("smtp");
                       transport.connect(host, user, pass);
                       transport.sendMessage(msg, msg.getAllRecipients());
                       transport.close();
                       System.out.println("Message send successfully");
                    }catch(Exception ex)
                    {
                        System.out.println(ex);
                    }
                    out.println("File uploaded!!!");

                    conn.close();

                    RequestDispatcher rs = request.getRequestDispatcher("try.jsp");
                    rs.include(request, response);
                }
                else
                {
                    out.println("Couldn't upload your file!!!");

                    conn.close();

                    RequestDispatcher rs = request.getRequestDispatcher("error.jsp");
                    rs.include(request, response);
                }    

            }catch(Exception e){e.printStackTrace();
            } 
}   
}