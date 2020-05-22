public class MailHelper {

    public static Promise<WS.Response> send(EmailData emailData) {
        WSRequestHolder mailGun = WS.url("https://api.mailgun.net/v2/feedmerang.com/messages");
        mailGun.setAuth("api", "MAILGUN_API_KEY");
        mailGun.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        mailGun.setQueryParameter("from", emailData.from);
        mailGun.setQueryParameter("to", emailData.to);
        mailGun.setQueryParameter("subject", emailData.subject);
        mailGun.setQueryParameter("html", emailData.body);
        return mailGun.post("Sending Email");
    }
}