import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.apache.commons.codec.binary.Base64;

import com.sendgrid.Attachments;
import com.sendgrid.Content;
import com.sendgrid.Email;
import com.sendgrid.Mail;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;

public class TestSGEmail {
  public static void main(String args[]) {

    final String path = "/Users/macuser/testxls.xlsx";

    byte[] bFile = null;
    try {
      bFile = Files.readAllBytes(new File(path).toPath());
    } catch (IOException e) {
      e.printStackTrace();
    }

    Attachments attachments3 = new Attachments();
    Base64 x = new Base64();
    String imageDataString = x.encodeAsString(bFile);
    attachments3.setContent(imageDataString);
    attachments3.setType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
    attachments3.setFilename("TestData.xlsx");
    attachments3.setDisposition("attachment");
    attachments3.setContentId("Banner");

    Email from = new Email("test@example.com");
    String subject = "Hello World from the SendGrid Java Library!";

    Email to = new Email("myemail@example.com");

    Content content = new Content("text/plain", "Hello, Email!");
    Mail mail = new Mail(from, subject, to, content);

    mail.addAttachments(attachments3);

    SendGrid sg = new SendGrid("SG.tGX184I");

    Request request = new Request();
    try {
      request.setMethod(Method.POST);
      request.setEndpoint("mail/send");
      request.setBody(mail.build());

      Response response = sg.api(request);
      System.out.println(response.getStatusCode());
      System.out.println(response.getBody());
      System.out.println(response.getHeaders());

    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }
}