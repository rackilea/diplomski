import java.io.IOException;
import java.io.StringReader;

import javax.swing.text.MutableAttributeSet;
import javax.swing.text.html.HTML.Attribute;
import javax.swing.text.html.HTML.Tag;
import javax.swing.text.html.HTMLEditorKit.Parser;
import javax.swing.text.html.HTMLEditorKit.ParserCallback;
import javax.swing.text.html.parser.ParserDelegator;

public class ExtractEmailBody
{
    public static void main(String[] args) throws IOException
    {
        String email = "<div dir=\"ltr\">420</div><div class=\"gmail_extra\"><br><br><div class=\"gmail_quote\">On Thu, Aug 8, 2013 at 4:14 PM, <span dir=\"ltr\">&lt; 3:50 AM+11111111111: (2/6)<a href=\"mailto:xxxxxx@gmail.com\" target=\"_blank\">xxxxxx@gmail.com</a>&gt;</span> wrote:<br> <blockquote class=\"gmail_quot 3:50 AM +14411111111: (3/6)e\" style=\"margin:0 0 0 .8ex;border-left:1px #ccc solid;padding-left:1ex\">414<div class=\"HOEnZb\"><div class=\"h5\"><br>DO_NOT_REPLY:This i 3:50 AM" +
                ": (4/6)s an email notification that you have received a text message from a customer in Kaarma. If you reply to this email, a text message or 3:50 AM" +
                "(5/6)email message will NOT go to the customer. Access the customer text message to send a reply. </div></div></blockquote></div> 3:50 AM" +
                   "(6/6)<br></div>";

        class EmailCallback extends ParserCallback
        {
            private String body_;
            private boolean divStarted_;

            public String getBody()
            {
                return body_;
            }

            @Override
            public void handleStartTag(Tag t, MutableAttributeSet a, int pos)
            {
                if (t.equals(Tag.DIV) && "ltr".equals(a.getAttribute(Attribute.DIR)))
                {
                    divStarted_ = true;
                }
            }

            @Override
            public void handleEndTag(Tag t, int pos)
            {
                if (t.equals(Tag.DIV))
                {
                    divStarted_ = false;
                }
            }

            @Override
            public void handleText(char[] data, int pos)
            {
                if (divStarted_)
                {
                    body_ = new String(data);
                }
            }
        }
        EmailCallback callback = new EmailCallback();
        Parser parser = new ParserDelegator();
        StringReader reader = new StringReader(email);
        parser.parse(reader, callback, true);
        reader.close();
        System.out.println(callback.getBody());
    }
}