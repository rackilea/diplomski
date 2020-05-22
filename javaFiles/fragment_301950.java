public void sendWave(List<Sprite> aliens) {
    aliens.add(new Alien1(100, 50, difficulty));
    // etc
}

List<Sprite> aliens = new ArrayList<>();
sendWave(aliens);
sendWave(aliens);