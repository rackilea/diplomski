public void removeImage(int index) {
     if(images != null) {
        try {
            images.remove(index);
        } catch (UnsupportedOperationException uoe) {
            images = new ArrayList<Image>(images);
            images.remove(index);
        }
     }
}