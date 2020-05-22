List<Enemy> enemies = new ArrayList<>();
for (int i = 0; i < nEnemies; ++i) {
   enemy = new Enemy(
       BitmapFactory.decodeResource(getResources(), R.drawable.enemy_pic)
   );
   enemies.add(enemy);
}