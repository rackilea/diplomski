public String imageUrl;

public void createAndShowImage() {
    try {
        String imageName = "/nice_images_folder/cool_image.jpg";
        File imageFile = new File(System.getenv("MANAGEMENT_FILES") + imageName);
        //Here goes your logic to create the file
        createImage(imageFile);
        //Here i use a fixed URL, you can do it as you see fit
        this.imageUrl = "http://localhost:8080/MyCoolApp/" + CoolFileServlet.BASE_URL + imageName + "?delete=true";
    } catch (Exception e) {
        e.printStackTrace();
    }
}