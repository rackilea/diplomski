Timer.schedule(
    new Task(){ 
        @Override 
        public void run() {
             spriteb.setPosition(random.nextInt(Gdx.graphics.getWidth()), random.nextInt(Gdx.graphics.getHeight()));
             spriter.setPosition(random.nextInt(Gdx.graphics.getWidth()), random.nextInt(Gdx.graphics.getHeight()));
             spriteg.setPosition(random.nextInt(Gdx.graphics.getWidth()), random.nextInt(Gdx.graphics.getHeight()));
        } 
    }, delay, interval);