try
    {   
        RunTimeContext rtc = new RunTimeContext( );
        rtc.setULocale( ULocale.getDefault( ) );

        Generator gr = Generator.instance( );
        GeneratedChartState gcs = null;
        Bounds bo = BoundsImpl.create( 0, 0, 600, 400 );
        gcs = gr.build( idr.getDisplayServer( ), chart, bo, null, rtc, null );

        idr.setProperty( IDeviceRenderer.FILE_IDENTIFIER, out ); 
        idr.setProperty(
                IDeviceRenderer.UPDATE_NOTIFIER,
                new EmptyUpdateNotifier( chart, gcs.getChartModel( ) ) );

        gr.render( idr, gcs );
    }