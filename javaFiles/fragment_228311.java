Platforms [] mainPlats;

void setup() {
  size(750, 400);

  mainPlats = new Platforms[3];
  mainPlats[0] = new Platforms(200, 200, 100, 15);
  mainPlats[1] = new Platforms(420, 300, 100, 15);
  mainPlats[2] = new Platforms(570, 350, 100, 15);
}

void draw() {
  level();
}


void level() {
  mainPlats[0].displayPlat();
  mainPlats[0].platMove();
  mainPlats[0].platTransition();

  mainPlats[1].displayPlat();
  mainPlats[1].platMove();
  mainPlats[1].platTransition();

  mainPlats[2].displayPlat();
  mainPlats[2].platMove();
  mainPlats[2].platTransition();
}