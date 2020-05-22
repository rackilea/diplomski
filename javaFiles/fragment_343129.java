public Image getImage() {
   return (Image) getStateHelper().eval("image");
}

public void setImage(Image image) {
    getStateHelper().put("image", image);
}