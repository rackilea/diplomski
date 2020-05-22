public class Item {
    private String text;
    private Bitmap image;
    private String page;


    public Item(Bitmap image,String text,String page){
        this.image = image;
        this.text = text;
        this.page = page;
    }

    public Bitmap getImage() {
        return image;
    }


    public String getText() {
        return text;
    }


    public String getPage() {
        return page;
    }
}