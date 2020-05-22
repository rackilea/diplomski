public YourClass implements IYoutubeTask
{
    //....

    public yourFunction()
    {
        YouTubeVidIDs newID = new YouTubeVidIDs(this);

        //excute asynctask
        newID.execute();

        // you can used to new YouTubeVidIDs().execute(); 
    }

    //....

    @Override
    public void onFinished(String YT_ID)
    {
        Movie movie1 = new Movie();
        movie1.setId(1);
        movie1.getId(1);
        movie1.setTitle("Masjid Al-Haram");
        movie1.setStudio("Mekkah, KSA");
        movie1.setDescription("Live Stream of Masjid Al-Haram");
        movie1.setCardImageUrl("http://3.bp.blogspot.com/-ZKjKucsPdzI/TudWC99CE_I/AAAAAAAAAD8/qvWdDtw5IW0/s1600/%2528393%2529.jpg");
        movie1.setyTubeID(YT_ID);
    }

    //...

    public interface IYoutubeTask
    {
        void onFinished(String YT_ID);
    }
}