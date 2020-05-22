public class SimpleObject {

    private String jobSite;
    private int imageID; // your R.drawable.image

    public SimpleObject(String jobSite, int imageID) {
        this.jobSite = jobSite;
        this.imageID = imageID;
    }

    public String getJobSite() {
        return jobSite;
    }

    public int getImageID() {
        return imageID;
    }
}