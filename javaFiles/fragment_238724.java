try
    boolean isImage(String image_path){
    Image image = new ImageIcon(image_path).getImage();
    if(image.getWidth(null) == -1){
         return false;
    }
    else{
         return true;
    }
}