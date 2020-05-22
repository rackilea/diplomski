for (int i = 0; i < bullCount.size(); i++) {
    for (int j = 0; j < enemy.size(); j++) {
        if(bullCount.get(i).getBounds().intersects(enemy.get(j).getBounds())) {
            enemy.remove(j);
            bullCount.remove(i);
            i--;
            break;
        }
    }
}