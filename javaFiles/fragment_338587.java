if (Game.moveX >= Game.WIDTH-50) {
    Game.deltaX =-1;
} else if (Game.moveX <= 0) {
    Game.deltaX =1;
}
Game.moveX += Game.deltaX;