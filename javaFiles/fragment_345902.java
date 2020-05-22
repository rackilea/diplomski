public List eat(ArrayList<Enemy> enemys) {
    ArrayList<Enemy> toRemove = new ArrayList<Enemy>();
    for(Enemy enemy : enemys) {
        if(enemy.location.x != location.x && enemy.location.y != location.y) { //check for self
            if(collidesWith(enemy)) {
                if(width > enemy.width) {
                    width += enemy.width;
                    height = width;
                    toRemove.add(enemy);
                }
            }
        }
    }

    return toRemove;
}

public void runGame() {
    for(Enemy enemy : enemys) {
        List eaten = enemy.eat(enemys);
        enemy.update();
    }
    enemys.removeAll(eaten);
    player.eat(enemys);
    player.update();
}