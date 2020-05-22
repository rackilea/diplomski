// The UDP Client

DatagramSocket ds = new DatagramSocket();
InetAddress ip = InetAddress.getByName("127.0.0.1");
DatagramPacket dp;
while (true)
{
    ByteArrayOutputStream baos = new ByteArrayOutputStream();

    BufferedImage img = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
    ImageIO.write(img, "jpeg", baos);
    baos.flush();

    byte[] buffer = baos.toByteArray();

    // FIRST CHANGE : YOU SHOULD USE THE BUFFER SIZE YOU WANT, LIKE 1024 INSTEAD OF buffer.length
    byte[][] dest=splitBytes(buffer, 1024);
    int len=0;
    if (buffer.length%10==0)
        len=10;
    else
        len=11;

    // SECOND CHANGE : YOU SHOULD SEND THE BUFFER LENGTH SO THAT THE SERVER KNOWS WHAT TO RECEIVE
    byte[] temp= new byte[] {
        (byte)(buffer.length&0xff),
        (byte)(buffer.length>>8&0xff),
        (byte)(buffer.length>>16&0xff),
        (byte)(buffer.length>>24&0xff)
    };
    dp=new DatagramPacket(temp,temp.length,ip,3000);
    ds.send(dp);

    System.out.println("sending "+buffer.length+ " bytes to server in " + dest.length+" buffers");

    for (byte[] bytes:dest)
    {
        dp= new DatagramPacket(bytes,bytes.length, ip, 3000);
        ds.send(dp);

        // be careful not to overflow the UDP write buffer
        Thread.sleep(1);
    }
}

// UDP Server

DatagramSocket ds = null;
try {
    ds = new DatagramSocket(3000);
} catch (SocketException e) {
    e.printStackTrace();
}

byte[] buf = new byte[1024];
DatagramPacket dp;

JFrame frame=new JFrame("hello");
Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
frame.setSize((int)dim.getWidth(),(int)dim.getHeight());
frame.setContentPane(this);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setVisible(true);

while (true)
{
    // RECEIVE THE IMAGE DATA LENGTH
    dp= new DatagramPacket(buf, 1024);
    try {
        ds.receive(dp);
    } catch (IOException e) {
        e.printStackTrace();
    }

    // CHANGE : READ THE DATA LENGTH FROM THE FIRST PACKET
    ByteArrayInputStream bais = new ByteArrayInputStream(dp.getData());
    int len = bais.read()+(bais.read()<<8)+(bais.read()<<16)+(bais.read()<<24);

    List<byte[]> blocks = new ArrayList<>();

    // MAIN REASON YOUR CODE DID NOT WORK : YOU ARE NOT READING AGAIN FROM THE NETWORK
    int received = 0;
    int index = 0;
    while (received<len)
    {
        ds.receive(dp);
        received+=dp.getLength();

        // BE CAREFUL NOT ADDING THE WHOLE BUFFER, JUST THE DATA !
        byte[] toAdd = Arrays.copyOf(dp.getData(), dp.getLength());
        blocks.add(toAdd);
    }

    byte[] imageData=concatenateByteArrays(blocks);

    bais=new ByteArrayInputStream(imageData);
    image= ImageIO.read(bais);
    System.out.println(image);

    this.repaint();
}