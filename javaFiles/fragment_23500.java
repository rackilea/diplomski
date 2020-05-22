// create an array of coordinates in x, y, x, y... format
int[] points = {  
  34, 163,
  67, 345,
  474, 84,
  682, 234,
  495, 396,
  174, 379,
  275, 574
};

void setup() {
  size(800, 600);
  smooth();  
  noFill();
}

void draw() {
  background(255);

  draw_curve_from_points(points);  // draw the curve
  draw_handles_on_points(points, 6, 126);  // draw the handles

}

// a function to draw the curve
void draw_curve_from_points(int[] _points) { 
  noFill();
  stroke(0);
  strokeWeight(1);

  int len = _points.length;
  beginShape();
  curveVertex(_points[0], _points[1]);  // the first point is duplicated to be used as control point
  for (int i = 0; i < len; i +=2) {
    curveVertex(_points[i], _points[i+1]);
  }
  curveVertex(_points[len-2], _points[len-1]);  // idem for last point
  endShape();
}

// draw handles on the points
void draw_handles_on_points(int[] _points, float _size, int _gray) {
  int len = _points.length;
  pushStyle();
  noStroke();
  fill(_gray);
  for (int i = 0; i < len; i +=2) {
    ellipse(_points[i], _points[i+1], _size, _size);
  }
  popStyle();
}