import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;


public class Client
{
    public static void main(String[] args) throws Exception
    {
        SSLSocketFactory socketBuilder = (SSLSocketFactory) SSLSocketFactory.getDefault();
        SSLSocket socket = (SSLSocket) socketBuilder.createSocket("irc.freenode.net", 6697);
        BufferedWriter writerChannel = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader readerChannel = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        String line, computerName, nick, login, channel = "#bot", channelPassword = "";
        long id = 1;

        computerName = java.net.InetAddress.getLocalHost().getHostName();
        nick = computerName + "_" + id;
        login = computerName + "_" + id;
        writerChannel.write("NICK " + nick + "\r\n"); // Join IRC with a specific Nick
        writerChannel.write("USER " + login + " 8 * :" + login + " \r\n"); // Join IRC with a specific User
        writerChannel.flush();

        while ((line = readerChannel.readLine()) != null)
        {
            if (line.indexOf("004") != -1) // If connected
            {
                break;
            }
            else if (line.indexOf("433") != -1) // If Nick already in use
            {
                id++;
                nick = computerName + "_" + id;
                login = computerName + "_" + id;
                writerChannel.write("NICK " + nick + "\r\n");
                writerChannel.write("USER " + login + " 8 * :" + login + " \r\n");
                writerChannel.flush();
            }
        }

        writerChannel.write("JOIN " + channel + " " + channelPassword + "\r\n"); // Join a channel
        writerChannel.flush();

        while ((line = readerChannel.readLine()) != null)
        {
            try
            {
                line = line.substring(line.indexOf("#"));
                channel = line.substring(0, line.indexOf(" "));

                if (line.toLowerCase().startsWith("ping")) // avoid ping time-out
                {
                    writerChannel.write("PONG :" + line.substring(5) + "\r\n");
                    writerChannel.flush();
                }
                else if (line.toLowerCase().contains("!ping"))
                {
                    writerChannel.write("PRIVMSG " + channel + " :pong\r\n");
                    writerChannel.flush();
                }
                else if (line.toLowerCase().contains("!join"))
                {
                    String newChannel = line.substring(line.indexOf("!join") + 6);
                    int stringPosition;
                    if ((stringPosition = newChannel.indexOf(" ")) != -1)
                    {
                        String newPassword = newChannel.substring(stringPosition + 1);
                        newChannel = newChannel.substring(0, stringPosition);
                        writerChannel.write("JOIN " + newChannel + " " + newPassword + "\r\n");
                        writerChannel.flush();
                    }
                    else
                    {
                        writerChannel.write("JOIN " + newChannel + "\r\n");
                        writerChannel.flush();
                    }
                }
                else if (line.toLowerCase().contains("!leave"))
                {
                    writerChannel.write("PART " + channel + "\r\n");
                    writerChannel.flush();
                }
                else if (line.toLowerCase().contains("!quit"))
                {
                    writerChannel.write("QUIT\r\n");
                    writerChannel.flush();
                    System.exit(0);
                }
            }
            catch (Exception e)
            {

            }
        }
    }
}