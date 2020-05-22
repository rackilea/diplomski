Uri uri = intent.getData();
        // HTC Desire Bug
        if ( uri == null && intent.getExtras() != null && intent.getExtras().get( "data" ) instanceof Bitmap ) {
            uri = createUriFromPhotoIntentForHtcDesireHD( activity, intent, uri );
            Ln.d( "The intent is %s", intent.getExtras().get( "data" ).getClass().getName() );
        }