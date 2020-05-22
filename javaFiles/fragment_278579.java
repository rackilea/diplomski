import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class SpitterModel  {

    private CommonsMultipartFile imageFile;

    public CommonsMultipartFile getImageFile() {
        return imageFile;
    }

    public void setImageFile(CommonsMultipartFile imageFile) {
        this.imageFile = imageFile;
    }

}