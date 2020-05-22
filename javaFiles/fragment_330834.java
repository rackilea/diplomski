final TextButton btOptions = new TextButton("Options", skin, "default");

    btOptions.addListener(new ClickListener(){
        @Override 
        public void clicked(InputEvent event, float x, float y){
            myGame.setScreen(new MyOptionsScreen(myGame));

        }
    });