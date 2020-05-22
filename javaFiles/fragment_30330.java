public void updatePlayerLaser(boolean shootLaser) {
        // Check if a new Laser should be created
        if(shootLaser == true) {
            if(timeLastCreatedLaser + 100 < System.currentTimeMillis()) {
                timeLastCreatedLaser = System.currentTimeMillis();
                boolean createdNewLaser = false;
                for(int i = 0; i < this.amountOfVisibleLasers; i++) {
                    if(createdNewLaser == false) {
                        if(holderLaser[i].isDisposed()) {
                            this.generateNewLaser(i);
                            createdNewLaser = true;

                        }
                    }
                }
            }
        }

        // Update all the other Lasers
        for(int i = 0; i < this.amountOfVisibleLasers; i++) {
            if(holderLaser[i].isDisposed() == false) {
                holderLaser[i].update();
            }

        }

    }