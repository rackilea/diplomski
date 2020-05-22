static final int ribbon_length = 255, H = 200;
float p;
int up_y, wide, high;

void setup() {
  size(ribbon_length, H);
  String[] lines = loadStrings("input.txt");
  p = float(split(lines[0], " = ")[1]);
  println(p);
  up_y = int(split(lines[1], " = ")[1]);
  println(up_y);
  wide = int(split(lines[2], " = ")[1]);
  println(wide);
  high = int(split(lines[3], " = ")[1]);
  println(high);
}

void draw() {
  float a = pow (ribbon_length, 1-p);
  float colour = 0;
  for (int step = 0; step <= 255; step++) {
      colour = a * pow (step, p);
      fill(colour,0,0);
      rect(wide*step, up_y, wide, high);
      noStroke();
   }
}