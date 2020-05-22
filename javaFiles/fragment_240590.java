void draw() {
    background(255);

    println(newletter, " ", jump);
    if(newletter == true) {
      player.drive(direction);
    }
    if(jump == true) {
        player.jump();
    }

    player.display();
}