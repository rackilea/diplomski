setContentView(R.layout.main);

// Look up the AdView as a resource and load a request.
adView = (AdView)this.findViewById(R.id.adView);
AdRequest adRequest = new AdRequest.Builder().build();
adView.loadAd(adRequest);

initialize (new RedSquare(), cfg);