for( int i = 0; i< eventCount; i++ ){
        MktDataEvent event = new MktDataEvent( "EDM6", 99.0, (100 + i), 99.50, (200 + i) );
        dispatcher.enqueue( event );
        long nanos = System.nanoTime();
        while( System.nanoTime() - nanos < 3000 )
            Thread.yield();

    }