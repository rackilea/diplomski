package com.xx.xx;

import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

public class Email {

    public Email() {
    }

    /*
     * @param args
     */
    public static void main(String[] args) {
        try {
            Email email = new Email();
            email.send();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void send() throws Exception {

        try {
            String from = "xx@xx.com";
            String to = "xx@xx.com";
            Properties prop = new Properties();
            prop.put("mail.smtp.host", "mailhost");

            Session session = Session.getDefaultInstance(prop, null);
            // Define message
            MimeMessage message = new MimeMessage(session);
            message.addHeaderLine("method=REQUEST");
            message.addHeaderLine("charset=UTF-8");
            message.addHeaderLine("component=VEVENT");

            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("Outlook Meeting Request Using JavaMail");

            StringBuffer sb = new StringBuffer();

            StringBuffer buffer = sb.append("BEGIN:VCALENDAR\n" +
                    "PRODID:-//Microsoft Corporation//Outlook 9.0 MIMEDIR//EN\n" +
                    "VERSION:2.0\n" +
                    "METHOD:REQUEST\n" +
                    "BEGIN:VEVENT\n" +
                    "ATTENDEE;ROLE=REQ-PARTICIPANT;RSVP=TRUE:MAILTO:xx@xx.com\n" +
                    "ORGANIZER:MAILTO:xx@xx.com\n" +
                    "DTSTART:20051208T053000Z\n" +
                    "DTEND:20051208T060000Z\n" +
                    "LOCATION:Conference room\n" +
                    "TRANSP:OPAQUE\n" +
                    "SEQUENCE:0\n" +
                    "UID:040000008200E00074C5B7101A82E00800000000002FF466CE3AC5010000000000000000100\n" +
                    " 000004377FE5C37984842BF9440448399EB02\n" +
                    "DTSTAMP:20051206T120102Z\n" +
                    "CATEGORIES:Meeting\n" +
                    "DESCRIPTION:This the description of the meeting.\n\n" +
                    "SUMMARY:Test meeting request\n" +
                    "PRIORITY:5\n" +
                    "CLASS:PUBLIC\n" +
                    "BEGIN:VALARM\n" +
                    "TRIGGER:PT1440M\n" +
                    "ACTION:DISPLAY\n" +
                    "DESCRIPTION:Reminder\n" +
                    "END:VALARM\n" +
                    "END:VEVENT\n" +
                    "END:VCALENDAR");

            // Create the message part
            BodyPart messageBodyPart = new MimeBodyPart();

            // Fill the message
            messageBodyPart.setHeader("Content-Class", "urn:content-  classes:calendarmessage");
            messageBodyPart.setHeader("Content-ID", "calendar_message");
            messageBodyPart.setDataHandler(new DataHandler(
                    new ByteArrayDataSource(buffer.toString(), "text/calendar")));// very important

            // Create a Multipart
            Multipart multipart = new MimeMultipart();

            // Add part one
            multipart.addBodyPart(messageBodyPart);

            // Put parts in message
            message.setContent(multipart);

            // send message
            Transport.send(message);
        } catch (MessagingException me) {
            me.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}