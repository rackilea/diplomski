void draw() {

  int num = 100;
    int interval = 100; // 0.5 seconds
    int time = millis();   // milliseconds  since starting the program
    if (paticles.size() < num && paticles.size()*interval+5000 < time) {
        paticles.add(new Particle(new PVector(random(width), random(height)), 100, 150));
    }

    background(0);
    for (int i = 0; i < paticles.size(); i ++) {
        Particle p = paticles.get(i);
        p.update(paticles, i);
    }
}