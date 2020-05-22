double sum_x = 0;
double sum_y = 0;
int j;
for (j = 0; j < hull.size().height; j++) {
     l.add(contours.toList().get(hull.toList().get(j)));
     sum_x += l.get(j).x;
     sum_y += l.get(j).y;
}
x = sum_x / j;
y = sum_y / j;