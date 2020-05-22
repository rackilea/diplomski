class Particle {

    PVector pos;
    PVector vel;

    float r, mr;

    float spd = 0.1;
    float max = 2;

    Particle(PVector pos, float r, float mr) {
        this.pos = pos;
        this.r = r;
        this.mr = mr;
        vel = new PVector(random(-1, 1), random(-1, 1));
    }

    void update(ArrayList<Particle> paticles, int i) {
        float h = map(mouseX, 0, width, 0, 255);
        pos.add(vel);

        if (pos.x < -10) pos.x = width;
        if (pos.x > width + 10) pos.x = 0;
        if (pos.y < -10) pos.y = height;
        if (pos.y > height + 10) pos.y = 0;

        vel.x = constrain(vel.x + random(-spd, spd), -max, max);
        vel.y = constrain(vel.y + random(-spd, spd), -max, max);

        for (int j = i + 1; j < paticles.size(); j ++) {
            Particle pj = paticles.get(j);
            float ang = atan2(pos.y - pj.pos.y, pos.x - pj.pos.x);
            float dist = pos.dist(pj.pos);

            if (dist < r) {
                stroke(h, 255, map(dist, 0, r, 255, 0));
                strokeWeight(map(dist, 0, r, 3, 0));
                line(pos.x, pos.y, pj.pos.x, pj.pos.y);

                float force = map(dist, 0, r, 4, 0);
                vel.x += force * cos(ang);
                vel.y += force * sin(ang);
            }
        }

        float ang = atan2(pos.y - mouseY, pos.x - mouseX);
        float dist = pos.dist(new PVector(mouseX, mouseY));

        if (dist < r) {
            stroke(0, 0, map(dist, 0, r, 255, 0));
            strokeWeight(map(dist, 0, r, 3, 0));
            line(pos.x, pos.y, mouseX, mouseY);

            float force = map(dist, 0, r, 30, 0);
            vel.x += force * cos(ang);
            vel.y += force * sin(ang);
        }
        noStroke();
        fill(h, 255, 255);
        ellipse(pos.x, pos.y, 5, 5);
    }
}