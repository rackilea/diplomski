import com.thoughtworks.xstream.XStream;


public class Test1 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Channel channel=new Channel();
        Image image=new Image();
        image.setUrl("http:://google.com");
        channel.setAtom_link("atomlink");
        channel.setImage(image);
        channel.setDescription("desc");
         XStream xstream = new XStream();
         xstream.alias("channel", Channel.class);

         System.out.println(xstream.toXML(channel));


    }

}