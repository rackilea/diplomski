public class CaptureFrame extends ImageFrame
{
private Map <String, String>cams = new HashMap<String, String>();
public static void main(String[] args) throws CaptureException
{
    new CaptureFrame(DefaultCaptureSystemFactorySingleton.instance()).run();
}

private CaptureSystem system;
private CaptureStream captureStream;
private final CaptureSystemFactory factory;
private volatile boolean disposing = false;

public CaptureFrame(CaptureSystemFactory factory)
{   
    super("LTI-CIVIL");
    this.factory = factory;
}

public void run() throws CaptureException
{
    initCapture();

    setLocation(200, 200);
    addWindowListener(new WindowAdapter()
    {
        public void windowClosing(WindowEvent e)
        {
            try
            {
                disposeCapture();
            } catch (CaptureException e1)
            {
                e1.printStackTrace();
            }
            System.exit(0);
        }
    });
    setVisible(true);
    pack();

    system = factory.createCaptureSystem();
    system.init();
    List <CaptureDeviceInfo>list = system.getCaptureDeviceInfoList();
    String[] possibilities = new String[list.size()];
    int i=0;
    for (CaptureDeviceInfo info : list){
        possibilities[i] = info.getDescription();
        cams.put(info.getDescription(), info.getDeviceID());
        i++;
    }
    String s = (String) JOptionPane.showInputDialog(
            this,
            "Please, choose needed web camera:\n",
            "Select one...",
            JOptionPane.PLAIN_MESSAGE,
            null,
            possibilities, null);
    captureStream = system.openCaptureDeviceStream(cams.get(s));
    captureStream.setObserver(new MyCaptureObserver());
    setSize(captureStream.getVideoFormat().getWidth(), captureStream.getVideoFormat().getHeight());
    startCapture();
}



public void initCapture() throws CaptureException
{
    system = factory.createCaptureSystem();
    system.init();
}

public void startCapture() throws CaptureException
{
    captureStream.start();
}

public void disposeCapture() throws CaptureException
{
    disposing = true;
    if (captureStream != null)
    {   System.out.println("disposeCapture: stopping capture stream...");
        captureStream.stop();
        System.out.println("disposeCapture: stopped capture stream.");
        captureStream.dispose();
        captureStream = null;
    }
    if (system != null)
        system.dispose();
    System.out.println("disposeCapture done.");
}

class MyCaptureObserver implements CaptureObserver
{
    public void onError(CaptureStream sender, CaptureException e)
    {   
        e.printStackTrace();
    }

    public void onNewImage(CaptureStream sender, com.lti.civil.Image image)
    {   
        if (disposing)
            return;
        try
        {
            setImage(AWTImageConverter.toBufferedImage(image));
        }
        catch (Throwable t)
        {   t.printStackTrace();
        }
    }
}
}