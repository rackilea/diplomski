float x = 0, y = 100, nx, ny, angle;
for (int i = 0; i < points; i++) {
  angle = i * TAU / points;
  nx = x * cos(a) - y * sin(a);
  ny = x * sin(a) + y * cos(a); 
  ellipse(nx, ny, 10, 10);
}