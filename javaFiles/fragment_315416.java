public class FavoutiteCampaignLocationDifference {

    private DataModel Fav;
    private DataModelCampaigns Campaign;

    FavoutiteCampaignLocationDifference(DataModel fav, DataModelCampaigns campaign) {
        this.Fav = fav;
        this.Campaign = campaign;
    }

    public DataModel getFav() {
        return Fav;
    }

    public void setFav(DataModel fav) {
        Fav = fav;
    }

    public DataModelCampaigns getCampaign() {
        return Campaign;
    }

    public void setCampaign(DataModelCampaigns campaign) {
        Campaign = campaign;
    }

    public String getDifference() {

        //<<<<<<<<<< assumes the same elevation/height >>>>>>>>>>

        double earth_radius = 6371;
        double fav_lattitude = Double.valueOf(Fav.getFAVCurrentLocationLAT());
        double fav_longitude = Double.valueOf(Fav.getFAVCurrentLocationLONG());
        double cam_lattitude = Double.valueOf(Campaign.getCampaignsLAT());
        double cam_longitude = new Double(Campaign.getCampaignsLONG());
        double lat_distance = Math.toRadians(fav_lattitude - cam_lattitude);
        double long_distance = Math.toRadians(fav_longitude - cam_longitude);
        double arc = (Math.sin(lat_distance / 2)
                * Math.sin(lat_distance /2 ))
                +  Math.cos(Math.toRadians(fav_lattitude)) * Math.cos(Math.toRadians(cam_lattitude))
                * Math.sin(long_distance / 2) * Math.sin(long_distance / 2);
        double c = 2 * Math.atan2(Math.sqrt(arc), Math.sqrt(1 - arc));
        double distance = Math.pow(earth_radius * c  * 1000,2);
        return String.valueOf(distance);
    }
}