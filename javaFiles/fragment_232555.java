public class MyImageView extends ImageView {
    private String imageName;

    @Override
    public void setImageResource(int resourceId) {
       imageName = getResources().getResourceEntryName(resourceId);
       super.setImageResource(resourceId);
    }

    public String getImageName() {
       return imageName;
    }
}