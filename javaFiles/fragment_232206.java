private void receive() {
    try {
        TwitterStream newTwitterStream = new TwitterStreamFactory()
                .getInstance(twitterAuth);
        newTwitterStream.addListener(new StatusListener() {

            public void onException(Exception e) {
                if (!arret) {
                    restart("Erreur pandant la reception des tweets", e);
                }

            }

            public void onTrackLimitationNotice(int arg0) {
                // TODO Auto-generated method stub

            }

            public void onStatus(Status status) {
                store(status);
            }

            public void onStallWarning(StallWarning arg0) {
                // TODO Auto-generated method stub
            }

            public void onScrubGeo(long arg0, long arg1) {
                // TODO Auto-generated method stub

            }

            public void onDeletionNotice(StatusDeletionNotice arg0) {
                // TODO Auto-generated method stub

            }
        });
        FilterQuery query = new FilterQuery();

        if (filter_mots.length > 0 || filter_utilisateurs.length >0) {
            if (filter_mots.length > 0){
                query.track(filter_mots);   
            }
            if (filter_utilisateurs.length >0){

                query.follow(filter_utilisateurs);  
            }
            newTwitterStream.filter(query);
        } else{
            newTwitterStream.sample();
        }
        setTwitterStream(newTwitterStream) ; 
        arret = false ; 

    } catch (Throwable t) {
        // En cas d'erreur on redémare le streaming 
        restart("Erreur pendant la reception des données ", t);
    }
}