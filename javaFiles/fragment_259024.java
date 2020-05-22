import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import javax.imageio.ImageIO;
import common.Frame;
import video.VideoCap;

public class VideoClientThread extends Thread
{
    private final String formatType = "jpg";
    private VideoCap     videoCap;
    private Socket       socket;
    private String       ip;
    private int          port;
    private boolean      calling;

    public VideoClientThread(VideoCap videoCap, Socket socket, String ip, int port, boolean calling)
    {
        this.videoCap = videoCap;
        this.socket = socket;
        this.ip = ip;
        this.port = port;
        this.calling = calling;
    }

    public void run()
    {
        try
        {
            socket = new Socket(ip, port);
            socket.setSoTimeout(5000);
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            Frame f;
            BufferedImage bufferedImage;
            while (calling)
            {
                ByteArrayOutputStream fbaos = new ByteArrayOutputStream();
                bufferedImage = videoCap.getOneFrame();
                ImageIO.write(bufferedImage, formatType, fbaos);
                f = new Frame(fbaos.toByteArray());
                oos.writeObject(f);
                oos.flush();
                bufferedImage.flush();
                // Thread.sleep(33);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        // catch (InterruptedException e)
        // {
        // e.printStackTrace();
        // }
    }
}