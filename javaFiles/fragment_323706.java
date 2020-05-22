/*
 * Upload File to twitPic and get url . Then append this url to your twitter message.
 */
public static String upload_twic_pic(File file)
                throws TwitterException {
        String url = null;
        if (file != null) {
    Configuration conf = new ConfigurationBuilder().setMediaProviderAPIKey(TWITPIC_KEY).build();
    ImageUpload upload = new ImageUploadFactory(conf).getInstance(MediaProvider.PLIXI); //Use ImageUploadFactory
                url = upload.upload(file);
        }
        return url;