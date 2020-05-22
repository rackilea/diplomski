public class TestClass {

    private static ImageCache image_cache;

    public static void main(String[] args) {
        URL img_url = null;
        image_cache = new ImageCache();

        try 
        {
            img_url = new File("C:/Users/User/Images/image.png").toURI().toURL();
            Image img = Toolkit.getDefaultToolkit ().createImage (img_url); 
            image_cache.put(img_url, img);
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }

        String html = "<html>" +
                "<body>"+
                "<img src=\"" + img_url.toString() + "\">" +
                "</body>" +
                "</html>";

        JEditorPane  swingbox = new JEditorPane ();
        swingbox.setEditorKit(new HTMLEditorKit());
        swingbox.setContentType("text/html");
        swingbox.setText(html);



        JFrame frame=new JFrame("Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(swingbox);

        Dictionary cache=(Dictionary)swingbox.getDocument().getProperty("imageCache");

        // put the cache if it is not present. it should be null in the beginning
        if (cache==null) {
            swingbox.getDocument().putProperty("imageCache",image_cache);
        }

        frame.setSize(800,600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    static class ImageCache extends Hashtable {

        public Object get(Object key) {

            Object result = super.get(key);

            if (result == null){
                result = Toolkit.getDefaultToolkit().createImage((URL) key);
                put(key, result);
            }

            return result;
        }
    }

}