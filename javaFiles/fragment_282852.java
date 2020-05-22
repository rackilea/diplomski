import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.format.VerticalAlignment;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class Stack {


    public static void main(String[] args) throws IOException {

        try {

            // *** for Database Connected ***//
            Connection connect = null;
            Statement s = null;

            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://localhost/mydatabase?user=root&password=root");

            s = connect.createStatement();

            String sql = "SELECT * FROM customer ORDER BY CustomerID ASC";

            ResultSet rec = s.executeQuery(sql);

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            WritableWorkbook workbook = Workbook.createWorkbook(baos);

            // *** Create Font ***//
            WritableFont fontBlue = new WritableFont(WritableFont.TIMES, 10);
            fontBlue.setColour(Colour.BLUE);

            WritableFont fontRed = new WritableFont(WritableFont.TIMES, 10);
            fontRed.setColour(Colour.RED);

            // *** Sheet 1 ***//
            WritableSheet ws1 = workbook.createSheet("mySheet1", 0);

            // *** Header ***//
            WritableCellFormat cellFormat1 = new WritableCellFormat(fontRed);
            // cellFormat2.setBackground(Colour.ORANGE);
            cellFormat1.setAlignment(Alignment.CENTRE);
            cellFormat1.setVerticalAlignment(VerticalAlignment.CENTRE);
            cellFormat1.setBorder(Border.ALL, BorderLineStyle.THIN);

            // *** Data ***//
            WritableCellFormat cellFormat2 = new WritableCellFormat(fontBlue);
            // cellFormat2.setWrap(true);
            cellFormat2.setAlignment(jxl.format.Alignment.CENTRE);
            cellFormat2.setVerticalAlignment(VerticalAlignment.CENTRE);
            cellFormat2.setWrap(true);
            cellFormat2.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.HAIR, jxl.format.Colour.BLACK);

            ws1.mergeCells(0, 0, 5, 0);
            Label lable = new Label(0, 0, "Customer Report", cellFormat1);
            ws1.addCell(lable);

            // *** Header ***//
            ws1.setColumnView(0, 10); // Column CustomerID
            ws1.addCell(new Label(0, 1, "CustomerID", cellFormat1));

            ws1.setColumnView(1, 15); // Column Name
            ws1.addCell(new Label(1, 1, "Name", cellFormat1));

            ws1.setColumnView(2, 25); // Column Email
            ws1.addCell(new Label(2, 1, "Email", cellFormat1));

            ws1.setColumnView(3, 12); // Column CountryCode
            ws1.addCell(new Label(3, 1, "CountryCode", cellFormat1));

            ws1.setColumnView(4, 10); // Column Budget
            ws1.addCell(new Label(4, 1, "Budget", cellFormat1));

            ws1.setColumnView(5, 10); // Column Used
            ws1.addCell(new Label(5, 1, "Used", cellFormat1));

            int iRows = 2;
             while((rec!=null) && (rec.next())) {
                ws1.addCell(new Label(0, iRows, rec.getString("CustomerID"), cellFormat2));
                ws1.addCell(new Label(1, iRows, rec.getString("Name"), cellFormat2));
                ws1.addCell(new Label(2, iRows, rec.getString("Email"), cellFormat2));
                ws1.addCell(new Label(3, iRows, rec.getString("CountryCode"), cellFormat2));
                ws1.addCell(new Label(4, iRows, rec.getString("Budget"), cellFormat2));
                ws1.addCell(new Label(5, iRows, rec.getString("Used"), cellFormat2));
                ++iRows;
             }

            workbook.write();
            workbook.close();

            System.out.println("Excel file created.");

            // Close
            try {
                if (connect != null) {
                    s.close();
                    connect.close();
                }
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            sendMail(baos);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void sendMail(ByteArrayOutputStream baos) throws AddressException, MessagingException {

        final String username = "your.mail.id@gmail.com";
        final String password = "your.password";

        Properties props = new Properties();
        props.put("mail.smtp.auth", true);
        props.put("mail.smtp.starttls.enable", true);
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("protocol", "smtp");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("from.mail.id@g_mail.com"));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("to.your.mail@g_mail.com"));
        message.setSubject("Testing Subject");
        message.setText("PFA");

        MimeBodyPart messageBodyPart = new MimeBodyPart();

        Multipart multipart = new MimeMultipart();

        messageBodyPart = new MimeBodyPart();

        String fileName = "attachmentName.xls";
        DataSource aAttachment = new ByteArrayDataSource(baos.toByteArray(), "application/octet-stream");
        messageBodyPart.setDataHandler(new DataHandler(aAttachment));
        messageBodyPart.setFileName(fileName);
        multipart.addBodyPart(messageBodyPart);

        message.setContent(multipart);

        System.out.println("Sending");

        Transport.send(message);

        System.out.println("Done");
    }

}