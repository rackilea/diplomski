@Override
    public void surfaceCreated(SurfaceHolder holder) {
        if(gameLoopThread.getState()==Thread.State.TERMINATED) {
            gameLoopThread=new GameLoopThread(this);
        }
        gameLoopThread.setRunning(true);
        gameLoopThread.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        boolean retry = true;
        gameLoopThread.setRunning(false);
        while (retry) {
            try {
                gameLoopThread.join();
                retry = false;
            }
            catch (InterruptedException e) {}
        }
    }

public void controleJeu(Carte carte) {
        if(deck1.contains(carte)) {
            if (carte.getEtat() == 0) {
                carte.setEtat(1);
                cartesRetournees1.add(carte);
                majAffichage(carte);

            }
            if (cartesRetournees1.size() == 2) {
                try {
                    gameLoopThread.sleep(500);
                }catch(InterruptedException ie) { ie.printStackTrace(); }
                int nouveauEtat = 0;
                if (cartesRetournees1.get(0).getMotif() == cartesRetournees1.get(1).getMotif()) {
                    nouveauEtat = -1;
                    this.nbPairsTrouvees++;
                }

                cartesRetournees1.get(0).setEtat(nouveauEtat);
                cartesRetournees1.get(1).setEtat(nouveauEtat);

                majAffichage(cartesRetournees1.get(0));
                majAffichage(cartesRetournees1.get(1));
                cartesRetournees1.remove(1);
                cartesRetournees1.remove(0);
            }
        }
        else if(deck2.contains(carte)) {
            if (carte.getEtat() == 0) {
                carte.setEtat(1);
                cartesRetournees2.add(carte);
                majAffichage(carte);
            }
            if (cartesRetournees2.size() == 2) {
                try {
                    gameLoopThread.sleep(500);
                }catch(InterruptedException ie) { ie.printStackTrace(); }
                int nouveauEtat = 0;
                if (cartesRetournees2.get(0).getMotif() == cartesRetournees2.get(1).getMotif()) {
                    nouveauEtat = -1;
                    this.nbPairsTrouvees++;
                }

                cartesRetournees2.get(0).setEtat(nouveauEtat);
                cartesRetournees2.get(1).setEtat(nouveauEtat);

                majAffichage(cartesRetournees2.get(0));
                majAffichage(cartesRetournees2.get(1));
                cartesRetournees2.remove(1);
                cartesRetournees2.remove(0);
            }
        }
        if (nbPairsTrouvees == nbDeck*6) { showPopupVictoire(this); this.victory = true; }
        System.out.println(nbDeck);
    }