int hour = 3;
  for (int a = 0; a < 360; a+=30) {
    float angle = radians(a);
    float x = cx + cos(angle) * secondsRadius;
    float y = cy + sin(angle) * secondsRadius;
    vertex(x, y);
    fill(255);

    text(hour, x, y);
    hour++;
    if(hour > 12){
      hour = 1;
    }
  }