addTestData();

    mydatamodellist = listFavoriteLocation(); // declared using List<DataModel> mydatamodellist;
    mydatamodelcampaignslist = Campaigns(); // declared using List<DataModelCampaigns> mydatamodelcampaignslist; 
    for (DataModel dm: mydatamodellist) {
        for (DataModelCampaigns dmc: mydatamodelcampaignslist) {
            Log.i("VALUES",
                    "Favourite is " + dm.getFAVCurrentLocationLAT() + "(lat) by " + dm.getFAVCurrentLocationLONG() + "(long)" +
                            "\tCampaign is " + dmc.getCampaignsLAT() + "(lat) by " + dmc.getCampaignsLONG() + "(long)"
            );
        }
    }