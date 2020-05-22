public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
        Image [] flyanimation = {new Image("res/copter1.png"), new Image("res/copter2.png"), 
                new Image("res/copter3.png"), new Image("res/copter4.png")};
        int [] duration = {300, 300, 300, 300};

        fly = new Animation(flyanimation, duration, false);
        sprite = fly;
    }