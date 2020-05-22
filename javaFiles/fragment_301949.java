public List<Sprite> sendWave() {
    List<Sprite> aliens = new ArrayList<>();
    aliens.add(new Alien1(100, 50, difficulty));
    // etc
    return aliens;
}

List<Sprite> aliens = sendWave();
aliens.addAll(sendWave);