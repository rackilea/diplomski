try {


        mGnMusicIdStream = new GnMusicIdStream(mGnUser, GnMusicIdStreamPreset.kPresetRadio, new IGnMusicIdStreamEvents() {
            @Override
            public void musicIdStreamProcessingStatusEvent(GnMusicIdStreamProcessingStatus gnMusicIdStreamProcessingStatus, IGnCancellable iGnCancellable) {
                Log.d(TAG,"gracenote gnsdk -- musicIdStreamProcessingStatusEvent(); event is: "+gnMusicIdStreamProcessingStatus);
            }

            @Override
            public void musicIdStreamIdentifyingStatusEvent(GnMusicIdStreamIdentifyingStatus gnMusicIdStreamIdentifyingStatus, IGnCancellable iGnCancellable) {
                Log.d(TAG,"gracenote gnsdk -- musicIdStreamIdentifyingStatusEvent(); event is: "+gnMusicIdStreamIdentifyingStatus);
            }

            @Override
            public void musicIdStreamAlbumResult(GnResponseAlbums gnResponseAlbums, IGnCancellable iGnCancellable) {

                Log.d(TAG,"gracenote gnsdk -- musicIdStreamAlbumResult();  responsealbums matches: "+gnResponseAlbums.resultCount());

                if (gnResponseAlbums.resultCount() > 0) {
                    try {
                        final GnAlbum albumResponse = gnResponseAlbums.albums().at(0).next();

                        final GnTrack trackResponse = albumResponse.trackMatched();

                        if (trackResponse != null) {
                            mEvent.postOnGNSearchResult(new ISongRecognitionResponse() {
                                @Override
                                public
                                @NonNull
                                String extractTrackTitle() {
                                    // seems that track title comes reliably from GnTrack and much of the rest is locked
                                    // up in the GnAlbum?
                                    if (trackResponse.title() != null) {
                                        return trackResponse.title().display();
                                    } else {
                                        return "";
                                    }
                                }

                                @Override
                                public
                                @NonNull
                                String extractTrackArtist() {
                                    if (albumResponse.artist() != null) {
                                        if(BuildConfig.RULE_DEBUG_LEVEL>0)
                                            Log.d(TAG,"gnsdk -- album artist says "+albumResponse.artist().name().display());
                                        return albumResponse.artist().name().display();
                                    } else {
                                        return "";
                                    }
                                }

                                @Override
                                public long extractTrackPosition() {
                                    return trackResponse.currentPosition();
                                }

                                @Override
                                public long extractTrackDuration() {
                                    return trackResponse.duration();
                                }

                                @Override
                                public byte[] extractCoverArtImageData() {
                                    // seems that base64 string of the image is not always/commonly available
                                    // at least as we're trying to access it here.  The sample app downloads the image
                                    // asynchronously from the URL, which seems more reliable
                                    String img64 = albumResponse.coverArt().asset(GnImageSize.kImageSizeSmall).imageDataBase64(); //trackResponse.content(GnContentType.kContentTypeImageCover).asset(GnImageSize.kImageSize220).imageDataBase64();

                                    if(img64 != null && !img64.isEmpty()) {
                                        return Base64.decode(img64, Base64.DEFAULT);
                                    }else{
                                        return null;
                                    }
                                }

                                @NonNull
                                @Override
                                public String extractCoverArtImageURL() {
                                    // beware: asking for specific image sizes has been known to cause
                                    // no cover art to come back even if there might be cover art at another size.
                                    // The sample app uses the categorical size qualifier constant kImageSizeSmall
                                    String httpURL = albumResponse.coverArt().asset(GnImageSize.kImageSizeSmall).urlHttp();

                                    return httpURL;
                                }
                            });
                        }//end if track response data is non-null
                        else {
                            mEvent.postOnGNSearchResult(null);
                        }
                    }catch(GnException e){
                        Log.e(TAG, "we received a response clbk, but failed to process it", e);
                    }
                }//end if greater than 0 results
                else{
                    //no results, so pass a null result to indicate a miss
                    mEvent.postOnGNSearchResult(null);
                }
            }

            @Override
            public void musicIdStreamIdentifyCompletedWithError(GnError gnError) {
                Log.e(TAG,"gnsdk -- musicIdStreamIdentifyCompletedWithError(); we received a response clbk, but failed to process it");
                mEvent.postOnGNSearchFailure(gnError.errorDescription());
            }

            @Override
            public void statusEvent(GnStatus gnStatus, long l, long l1, long l2, IGnCancellable iGnCancellable) {
                Log.e(TAG,"gnsdk -- statusEvent(); status is: "+gnStatus);
            }
        });

        //configure the options on the gnmusicidstream instance
        mGnMusicIdStream.options().lookupData(GnLookupData.kLookupDataContent, true);
        mGnMusicIdStream.options().lookupData(GnLookupData.kLookupDataSonicData, true);
        mGnMusicIdStream.options().lookupMode(GnLookupMode.kLookupModeOnline);
        mGnMusicIdStream.options().preferResultCoverart(true);
        mGnMusicIdStream.options().resultSingle(true);

        //configure audio processing params on gnmusicidstream
        mGnMusicIdStream.audioProcessStart(sampleRateHz,pcmBitcount,channelCount);

        //pass the pcm array to the gnmusicidstream for processing
        mGnMusicIdStream.audioProcess(pcmArray,pcmArray.length);

        //initiate the lookup operation based on the processed pcm
        mGnMusicIdStream.identifyAlbumAsync();


    }catch(GnException e){
        Log.e(TAG,"gnsdk -- failed recognition operation",e);
    }