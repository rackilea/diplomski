synchronized( threads )
            {
                for( int i = 0; i < threads.size(); i++ )
                {
                    if( !threads.get( i ).isAlive() )
                    {
                        threads.get( i ).interrupt();
                        threads.remove( i );
                    }
                }
            }

            synchronized( threadsMonitor )
            {
                try
                {
                    threadsMonitor.wait( 5000 );
                }
                catch( InterruptedException e )
                {
                    threadsMonitor.interrupted();
                    return;
                }