@Named
public class ImageBean {
    private StreamedContent image;
    @PostConstruct
    public void init() {
        image = new DefaultStreamedContent(new ByteArrayInputStream(byteArray)); // your byte array
    } 
    // setter and getter for image omitted
}