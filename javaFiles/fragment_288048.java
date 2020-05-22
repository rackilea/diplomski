mPublishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(p_photo_url == null) {
                ...
                } else {

                    // Create offer from user input
                    Offer n_offer = new Offer   (...)
                    );

                    ...

                    // Return offer to EditOffersActivity
                    Intent resultIntent = new Intent();
                    resultIntent.putExtra("offer", n_offer); // Offer is Parcelable
                    setResult(HTZ_ADD_OFFER, resultIntent);
                    OfferAdapter.notifydatasetchanged();
                    finish();
                }
            }
        });