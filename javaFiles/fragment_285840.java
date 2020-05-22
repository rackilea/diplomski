camera.up.set(0,1,0); //Not sure if this is necessary. 
                      //Making sure up is always up after 
                      //last frame's lookAt() call.
camera.postion.set(player.position)
    .add(-UNITS_BACK, UNITS_UP, 0)
    .rotate(Vector3.UP, player.angle);
camera.lookAt(player.position);
camera.update();