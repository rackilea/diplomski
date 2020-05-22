Enemy[] enemy = new Enemy[3];
for(int i = 0; i < enemy.length; i++){
    enemy[i] = new Enemy(canvas, context);
    enemy[i].printCoordinates(); // just used for printing the generated coordinates
    enemy[i].draw();
}