List<Enemy> enemies = new ArrayList<>();
Bitmap enemyBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.enemy_pic);
for (int i = 0; i < nEnemies; ++i) {
   enemy = new Enemy(enemyBitmap);
   enemies.add(enemy);
}