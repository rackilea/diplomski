//Sets the footstep sound. i.e. it changes to a grass soundfile when you walk on grass.
String footstepsFilePath = gameMap.getTileSoundFilePath(rect);
setFootsteps(Gdx.audio.newSound(Gdx.files.internal(footstepsFilePath)));

boolean isMoving = false;

//velocity is the speed at which the player is going in the x or y direction.
if((velocity.y != 0 || velocity.x != 0) && !isMoving) {
    isMoving = true;
    footsteps.loop();
}

if((velocity.y == 0 && velocity.x == 0) && isMoving) {
    footsteps.stop();
    isMoving = false;
}