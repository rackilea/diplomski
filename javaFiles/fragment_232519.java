public class Feed
{
    private String id;
    private String imagePath;
    private Moderator moderator;
    private String description;
    private String rejected;
    private Uploader uploader;
    private String moderatedOn;
    private String[] imagePaths;
    public String getId ()
    {
        return id;
    }
    public void setId (String id)
    {
        this.id = id;
    }
    public String getImagePath ()
    {
        return imagePath;
    }
    public void setImagePath (String imagePath)
    {
        this.imagePath = imagePath;
    }
    public Moderator getModerator ()
    {
        return moderator;
    }
    public void setModerator (Moderator moderator)
    {
        this.moderator = moderator;
    }
    public String getDescription ()
    {
        return description;
    }
    public void setDescription (String description)
    {
        this.description = description;
    }
    public String getRejected ()
    {
        return rejected;
    }
    public void setRejected (String rejected)
    {
        this.rejected = rejected;
    }
    public Uploader getUploader ()
    {
        return uploader;
    }
    public void setUploader (Uploader uploader)
    {
        this.uploader = uploader;
    }
    public String getModeratedOn ()
    {
        return moderatedOn;
    }
    public void setModeratedOn (String moderatedOn)
    {
        this.moderatedOn = moderatedOn;
    }
    public String[] getImagePaths ()
    {
        return imagePaths;
    }
    public void setImagePaths (String[] imagePaths)
    {
        this.imagePaths = imagePaths;
    }
}