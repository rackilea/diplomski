PendingResult<PlaceLikelihoodBuffer> result = Places.PlaceDetectionApi
                        .getCurrentPlace(mGoogleApiClient, null);
                result.setResultCallback(new ResultCallback<PlaceLikelihoodBuffer>() {
                    @Override
                    public void onResult(PlaceLikelihoodBuffer likelyPlaces) {
                        ArrayList<String> nearbyPlaces = new ArrayList<>();
                        for (final PlaceLikelihood placeLikelihood : likelyPlaces) {
                            nearbyPlaces.add(placeLikelihood.getPlace().getName().toString());
                            // here, placeLikelihood.getPlace().getName() returns name of nearby places
                        }
                        likelyPlaces.release();
                    }
                });