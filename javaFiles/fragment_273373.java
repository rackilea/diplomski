public void start(){
    new Tile();
    level = new Level();
    p1 = new MainCharacter(20,40);

    isRunning = true;
    new Thread(this).start();
}