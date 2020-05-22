final CyclicBarrier c = new CyclicBarrier(2);

    Runnable r1 = new Runnable()
    {

        @Override
        public void run()
        {
            while ( !labyrinthe.sortir(bob3) )
            {

                Collection<Salle> sallesAccessibles = labyrinthe.sallesAccessibles(bob3);
                if ( bob3.peutSeDeplacer() )
                    destination = bob3.faitSonChoix(sallesAccessibles); // on demande au heros de faire son choix de salle
                if ( destination != bob3.getPosition() )
                    destination.recevoir(bob3); // deplacement
            }
            try
            {
                c.await();
            }
            catch ( InterruptedException e )
            {
                ;
            }
            catch ( BrokenBarrierException e )
            {
                ;
            }
        }
    };

    Runnable r2 = new Runnable()
    {
        @Override
        public void run()
        {
            while ( !labyrinthe.sortir(bob2) )
            {
                Collection<Salle> sallesAccessibles = labyrinthe.sallesAccessibles(bob2);
                if ( bob2.peutSeDeplacer() )
                    destination = bob2.faitSonChoix(sallesAccessibles); // on demande au heros de faire son choix de salle
                if ( destination != bob2.getPosition() )
                    destination.recevoir(bob2); // deplacement

            }
            try
            {
                c.await();
            }
            catch ( InterruptedException e )
            {
                ;
            }
            catch ( BrokenBarrierException e )
            {
                ;
            }
        }
    };

    Thread t1 = new Thread(r1);
    Thread t2 = new Thread(r2);

    t1.start();
    t2.start();

    c.await();

    System.out.println("Done");