import com.independentsoft.webdav.exchange.Message;
import com.independentsoft.webdav.exchange.WebdavClient;
import com.independentsoft.webdav.exchange.WebdavException;

public class Example {

    public static void main(final String[] args)
    {
        try
        {
            WebdavClient client = new WebdavClient("https://myserver/exchange/emailaddress", "username", "password");

            //get single message
            Message message = client.getMessage("messageUrl");

            //get all messages from the Inbox folder
            Message[] messages = client.getMessages();

            //get all messages from the specified folder
            Message[] messages2 = client.getMessages("folderUrl");
        }
        catch (WebdavException e)
        {
            e.printStackTrace();
        }
    }
}