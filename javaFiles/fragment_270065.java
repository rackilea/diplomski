Button button = new Button(skin, "buildButton");

     button.addListener(buildListener);

     ...

     ClickListener buildListener = new ClickListener()
            {
                public void clicked(InputEvent event, float x, float y) 
                {
                    if( cash > BUILDING_COST )
                    {
                        Image building = createBuildig(); //it can be also some class inherits actor if you want it to have some more informations
                        building.setPosition(position.x, position.y); //some position

                        //you can also add actor to some array to process it lateer somehow...

                        stage.addActor( building );
                    }
                }
    };