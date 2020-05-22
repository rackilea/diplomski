ListIterator<Enemy> enemyIterator = enemy.listIterator();
while (enemyIterator.hasNext()) {
    Rectangle r2 = enemyIterator.next().getBounds();
    if(r1.intersects(r2)) {
        enemyIterator.remove();
    }
}