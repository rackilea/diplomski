boolean north = false, east = false, south = false, west = false;

    scene.setOnMouseMoved(e -> {
        if(e.getX()>750)
        {
            east = true;
        }else if(e.getX()<50)
        {
            west = true;
        }else{
            east = false;
            west = false;
        }
        if(e.getY()>550)
        {
            south = true;
        }else if(e.getY()<50)
        {
            north = true;
        }else{
            north = false;
            south = false;
        }
    });
    AnimationTimer timer = new AnimationTimer() {
        @Override
        public void handle(long now) {
            if(east)camera.cameraControlX(-0.5);
            if(west)camera.cameraControlX(0.5);
            if(south)camera.cameraControlY(-0.5);
            if(north)camera.cameraControlY(0.5);
        }
    };
    timer.start();