import com.orm.SugarRecord;

public class ImageSugarPojo extends SugarRecord{

private String image;
private String text;

public ImageSugarPojo(){}

public ImageSugarPojo(String image, String text){
    this.image =image;
    this.text = text;
}

public String getImage() {
    return image;
}

public void setImage(String image) {
    image = image;
}

public String getText() {
    return text;
}

public void setText(String text) {
    this.text = text;
}
}